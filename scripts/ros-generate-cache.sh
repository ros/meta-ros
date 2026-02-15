# /bin/sh (deliberately no !#)
#
# Usage: cd meta-ros
#        sh scripts/ros-generate-cache.sh ROS_DISTRO YYYY-MM-DD PATH-TO-LOCAL-ROS-ROSDISTRO ROS-ROSDISTRO-COMMIT [BRANCH_NAME]
#            or
#        sh scripts/ros-generate-cache.sh --version
#
# Generate and commit a cache.yaml for the YYYY-MM-DD release of ROS_DISTRO from the specified commit of a local
# ros/rosdistro.git. YYYY-MM-DD is taken from the release announcement or the last field of the "<ROS_DISTRO>/YYYY-MM-DD"
# tag in rosdistro repository; if running prior to first release of ROS_DISTRO, specify "pre-release" for YYYY-MM-DD.
# Note that the release date generally does not match the commit timestamp of ROS-ROSDISTRO-COMMIT; however, the commit timestamp
# is used for the DATETIME when forming the name of the created branch. Optionally you can set your own branch name in
# or use ":nobranch" to prevent the creation of a new branch.
#
# The files from PATH-TO-LOCAL-ROS-ROSDISTRO/rosdep are to rosdep. The script will abort if the entries in
# /etc/ros/rosdep/sources.list.d/20-default.list do not point to files under PATH-TO-LOCAL-ROS-ROSDISTRO/rosdep .
#
# Copyright (c) 2019-2021 LG Electronics, Inc.

readonly SCRIPT_NAME="ros-generate-cache"
readonly SCRIPT_VERSION="1.9.0"

# Files under ros/rosdistro/rosdep that we care about. Keep in sync with setting in ros-generate-recipes.sh .
readonly ROSDEP_YAML_BASENAMES="base python ruby"

usage() {
    echo "Usage: cd meta-ros"
    echo "       sh scripts/$SCRIPT_NAME.sh ROS_DISTRO YYYY-MM-DD PATH-TO-LOCAL-ROS-ROSDISTRO ROS-ROSDISTRO-COMMIT [BRANCH_NAME]"
    echo "               or"
    echo "       sh scripts/$SCRIPT_NAME.sh --version"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

[ $# -ne 4 -a $# -ne 5 ] && usage

ROS_DISTRO=$1
ROS_DISTRO_RELEASE_DATE=$2
ROS_ROSDISTRO_CHECKOUT_PATH=$3
ROS_ROSDISTRO_COMMIT=$4
BRANCH_NAME=$5

# Keep this block in sync with the one in ros-generate-recipes.sh .
case $ROS_DISTRO in
    "melodic"|"noetic")
        ROS_VERSION="1"
        ;;

    "dashing"|"eloquent"|"foxy"|"galactic"|"humble"|"iron"|"jazzy"|"kilted"|"rolling")
        ROS_VERSION="2"
        ;;

    *)  echo "ABORT: Unrecognized ROS_DISTRO: $ROS_DISTRO"
        exit 1
        ;;
esac

# Keep this block in sync with the one in ros-generate-recipes.sh .
case $ROS_DISTRO_RELEASE_DATE in
    final|pre-release|[2-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9])
        : OK
        ;;

    *)  echo "ABORT: ROS_DISTRO_RELEASE_DATE not YYYY-MM-DD or 'final' or 'pre-release': '$ROS_DISTRO_RELEASE_DATE'"
        exit 1
        ;;
esac

if [ ! -d $ROS_ROSDISTRO_CHECKOUT_PATH ]; then
    echo "ABORT: '$ROS_ROSDISTRO_CHECKOUT_PATH' not found"
    exit 1
fi

cd $ROS_ROSDISTRO_CHECKOUT_PATH
path_to_ros_rosdistro=$PWD
ROS_ROSDISTRO_COMMIT=$(git rev-list -1 $ROS_ROSDISTRO_COMMIT) || { echo "ABORT: commit '$ROS_ROSDISTRO_COMMIT' doesn't exist in '$ROS_ROSDISTRO_CHECKOUT_PATH'"; exit 1; }

commit_timestamp=$(git log -1 --date=iso-strict --format=%cd $ROS_ROSDISTRO_COMMIT)
# Associate the cache update with the commit date of <ROSDISTRO-COMMIT>.
export ROS_ROSDISTRO_COMMIT_DATETIME=$(date +%Y%m%d%H%M%S --utc -d $commit_timestamp)
unset commit_timestamp
cd - > /dev/null

abort=false
[ -z "$ROSDEP_SOURCE_PATH" ] && ROSDEP_SOURCE_PATH="/etc/ros/rosdep/sources.list.d"
for f in $ROSDEP_YAML_BASENAMES; do
    if ! grep -q "^yaml file://$path_to_ros_rosdistro/rosdep/$f.yaml\$" $ROSDEP_SOURCE_PATH/20-default.list; then
        echo "ABORT: $ROSDEP_SOURCE_PATH/20-default.list doesn't point to $f.yaml in $path_to_ros_rosdistro"
        abort=true
    fi
done
unset f
$abort && exit 1
unset abort

# Keep this block in sync with the one in ros-generate-recipes.sh .
if [ -n "$(git status --porcelain=v1)" ]; then
    echo "ABORT: Uncommitted modifications detected by Git -- perhaps invoke 'git reset --hard'?"
    exit 1
fi

# Done checking things.

tmpdir=$(mktemp -t -d ros-generate-cache-XXXXXXXX)
trap "rm -rf $tmpdir" 0

function set_release_version {
    package=$1
    oldversion=$2
    newversion=$3

    python3 <<HEREDOC
from ruamel.yaml import YAML

yaml = YAML()
yaml.preserve_quotes = True  # keep existing quotes if any

def set_release_version(data, repo_name, oldversion, newversion):
    print("set_release_version")
    if repo_name in data.get("repositories", {}):
        release_section = data["repositories"][repo_name].get("release", {})
        if "version" in release_section:
            if release_section["version"] == oldversion:
                release_section["version"] = newversion

# Load the file
with open("$ROS_DISTRO/distribution.yaml", "r") as f:
    data = yaml.load(f)

set_release_version(data, '$1', '$2', '$3')

# Write back the file
with open("$ROS_DISTRO/distribution.yaml", "w") as f:
    yaml.dump(data, f)
HEREDOC
}

# Create a directory tree under $tmpdir with the contents of ros/rosdistro.git at commit $ROS_ROSDISTRO_COMMIT.
cd $path_to_ros_rosdistro
git archive $ROS_ROSDISTRO_COMMIT | tar -C $tmpdir -xf -
cd - > /dev/null

# Create $tmpdir/$ROS_DISTRO-cache.yaml.gz .
cd $tmpdir

# Make changes to distribution.yaml
if [ "$ROS_DISTRO" = "dashing" -o "$ROS_DISTRO" = "eloquent" ] ; then
    sed 's#boschresearch/fmilibrary_vendor-release#ros2-gbp/fmilibrary_vendor-release#g' -i $ROS_DISTRO/distribution.yaml
    sed 's#boschresearch/fmi_adapter_ros2-release#ros2-gbp/fmi_adapter-release#g' -i $ROS_DISTRO/distribution.yaml
    sed 's#fmi_adapter_ros2#fmi_adapter#g' -i $ROS_DISTRO/distribution.yaml
fi

if [ "$ROS_DISTRO" = "kilted" ] ; then
   set_release_version 'py_binding_tools' '2.0.2-1' '2.1.0-1'
fi

rosdistro_build_cache --debug --preclean --ignore-local $tmpdir/index-v4.yaml $ROS_DISTRO
if [ $? -ne 0 ]; then
    echo "ABORT: rosdistro_build_cache returned a runtime error"
    exit 1
fi

if [ ! -f $tmpdir/index-v4.yaml ]; then
    echo "ABORT: $tmpdir/index-v4.yaml could not be found."
    exit 1
fi

if [ ! -f $tmpdir/$ROS_DISTRO-cache.yaml.gz ]; then
    echo "ABORT: $tmpdir/$ROS_DISTRO-cache.yaml.gz could not be found."
    exit 1
fi

cd - > /dev/null

# Keep this block in sync with the one in ros-generate-recipes.sh .
echo "Running 'rosdep update'"
rosdep update || { echo "ABORT: 'rosdep update' failed"; exit 1; }
echo "'rosdep update' finished"

generated="meta-ros$ROS_VERSION-$ROS_DISTRO/files/$ROS_DISTRO/generated"
mkdir -p $generated
gzip -d $tmpdir/$ROS_DISTRO-cache.yaml.gz -c > $generated/cache.yaml
# Identify how the files were generated so that they can be reused.
sed -i -e "1 i# $ROS_DISTRO/cache.yaml $ROS_DISTRO_RELEASE_DATE $ROS_ROSDISTRO_COMMIT $ROS_ROSDISTRO_COMMIT_DATETIME $SCRIPT_VERSION" $generated/cache.yaml
sed -e 's@{\([^ }][^ }]*\)}@[[\1]]@g' -e 's@{@{\n@g' -e 's@}@\n}@g' -e 's@\[\[@{@g' -e 's@]]@}@g' -e 's@, @,\n@g' \
    -e 's@^    @-----\n@' -e 's@<version>[^<]*</version>@@' -e 's@><@>\n<@g' -e 's@^  @-----\n@' \
    -e 's@^\(source_repo_package_xmls:\)@-----\n\1@' \
    $generated/cache.yaml > $generated/cache.diffme

mkdir -p $generated/rosdep
cp -f $tmpdir/index-v4.yaml $generated/
for f in $ROSDEP_YAML_BASENAMES; do
    cp -f $path_to_ros_rosdistro/rosdep/$f.yaml $generated/rosdep/
done
unset f

if [ "$BRANCH_NAME" != ":nobranch" ] ; then
    [ -z "$BRANCH_NAME" ] && BRANCH_NAME="superflore/$ROS_DISTRO/$ROS_DISTRO_RELEASE_DATE"
    if git branch | grep -q " $BRANCH_NAME$"; then
        echo "ERROR: branch '$BRANCH_NAME' already exists, will create a new commit in currently checked out branch"
    else
        git checkout -b $BRANCH_NAME || echo "ERROR: creating branch '$BRANCH_NAME' failed, will create a new commit in currently checked out branch"
    fi
fi
git add $generated/
if [ $ROS_DISTRO_RELEASE_DATE = "final" ]; then
    release="final"
elif [ $ROS_DISTRO_RELEASE_DATE = "pre-release" ]; then
    release="pre-release"
else
    release="release $ROS_DISTRO_RELEASE_DATE"
fi
git commit \
    -s \
    -m "{$ROS_DISTRO} Update cache.yaml and rosdep files for $ROS_DISTRO $release as of $ROS_ROSDISTRO_COMMIT_DATETIME" \
    -m "Generated by running:" \
    -m "    $0 $*"
unset release
