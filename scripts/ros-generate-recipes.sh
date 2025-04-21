# /bin/sh (deliberately no !#)
#
# Usage: cd meta-ros
#        [SUPERFLORE_GEN_OE_RECIPES=/path/to/superflore-gen-oe-recipes] sh scripts/ros-generate-recipes.sh \
#           ROS_DISTRO [ROS_PKG1 ROS_PKG2 ...]
#               or
#           --from-local-source ROS_DISTRO /path/to/package.xml  (not yet implemented)
#               or
#           --version
#
# Generate (or re-generate) recipes for ROS_DISTRO from an existing cache.yaml. If no ROS_PKG arguments are
# given, then all of the recipes for ROS_DISTRO are generated.
#
# This script will abort if Git detects any uncommitted modifications, eg, from a previous run that did not complete or untracked
# files (which would otherwise appear in superflore-change-summary.txt).
#
# Copyright (c) 2019-2021 LG Electronics, Inc.

readonly SCRIPT_NAME="ros-generate-recipes"
readonly SCRIPT_VERSION="1.8.0"

# Files under ros/rosdistro/rosdep that we care about. Keep in sync with setting in ros-generate-cache.sh .
readonly ROSDEP_YAML_BASENAMES="base python ruby"

usage() {
    echo "Usage: cd meta-ros"
    echo "       [SUPERFLORE_GEN_OE_RECIPES=/path/to/superflore-gen-oe-recipes] sh scripts/$SCRIPT_NAME.sh \\"
    echo "          ROS_DISTRO [ROS_PKG1 ROS_PKG2 ...]"
    echo "               or"
    echo "          --from-local-source ROS_DISTRO /path/to/package.xml  (not yet implemented)"
    echo "               or"
    echo "          --version"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

[ $# -eq 0 ] && usage

[ -z "$SUPERFLORE_GEN_OE_RECIPES" ] && SUPERFLORE_GEN_OE_RECIPES=$(which superflore-gen-oe-recipes)
if [ -z "$SUPERFLORE_GEN_OE_RECIPES" ]; then
    echo "ABORT: superflore-gen-oe-recipes not found"
    exit
fi

ROS_DISTRO=$1

# Keep this block in sync with the one in ros-generate-cache.sh .
case $ROS_DISTRO in
    "melodic"|"noetic")
        ROS_VERSION="1"
        ;;

    "dashing"|"eloquent"|"foxy"|"galactic"|"humble"|"iron"|"jazzy"|"rolling")
        ROS_VERSION="2"
        ;;

    *)  echo "ABORT: Unrecognized ROS_DISTRO: $ROS_DISTRO"
        exit 1
        ;;
esac

only_option=""
if [ $# -gt 1 ]; then
    shift
    only_option="--only $*"
fi

generated=meta-ros$ROS_VERSION-$ROS_DISTRO/files/$ROS_DISTRO/generated
if [ ! -f $generated/cache.yaml ]; then
    echo "ABORT: $generated/cache.yaml doesn't exist -- run ros-generate-cache.sh to create it"
    exit 1
fi

if [ ! -f $generated/index-v4.yaml ]; then
    echo "ABORT: $generated/index-v4.yaml doesn't exist -- run ros-generate-cache.sh to create it"
    exit 1
fi

set -- $(head -n 1 $generated/cache.yaml)
ROS_DISTRO_RELEASE_DATE=$3
ROS_ROSDISTRO_COMMIT=$4
ROS_ROSDISTRO_COMMIT_DATETIME=$5
ROS_GENERATE_CACHE_VERSION=$6

if [ -z "$ROS_DISTRO_RELEASE_DATE" -o -z "$ROS_ROSDISTRO_COMMIT" -o -z "$ROS_ROSDISTRO_COMMIT_DATETIME" -o -z "$ROS_GENERATE_CACHE_VERSION" ] ; then
    echo "ABORT: $generated/cache.yaml should start with '# $ROS_DISTRO/cache.yaml' and 4 space separated values:"
    echo "       ROS_DISTRO_RELEASE_DATE, ROS_ROSDISTRO_COMMIT, ROS_ROSDISTRO_COMMIT_DATETIME ROS_GENERATE_CACHE_VERSION. Run ros-generate-cache.sh to"
    echo "       re-create it."
    exit 1
fi

# Keep this block in sync with the one in ros-generate-cache.sh .
case $ROS_DISTRO_RELEASE_DATE in
    pre-release|[2-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9])
        : OK
        ;;

    *)  echo "ABORT: ROS_DISTRO_RELEASE_DATE not YYYY-MM-DD or 'pre-release': '$ROS_DISTRO_RELEASE_DATE'"
        exit 1
        ;;
esac

# Keep this block in sync with the one in ros-generate-cache.sh .
if [ -n "$(git status --porcelain=v1)" ]; then
    echo "ABORT: Uncommitted modifications detected by Git -- perhaps invoke 'git reset --hard'?"
    exit 1
fi

abort=false
[ -z "$ROSDEP_SOURCE_PATH" ] && ROSDEP_SOURCE_PATH="/etc/ros/rosdep/sources.list.d"
for f in $ROSDEP_YAML_BASENAMES; do
    ff=$(sed -n "\@^yaml file:/.*/$f.yaml\$@ s@.*file://@@p" $ROSDEP_SOURCE_PATH/20-default.list)
    if [ -z "$ff" ] ; then
        abort=true
        echo "ERROR: $ROSDEP_SOURCE_PATH/20-default.list doesn't have file://.*/$f.yaml, maybe it's using, the default URL over http:// (yaml https://raw.githubusercontent.com/ros/rosdistro/master/rosdep/$f.yaml)?"
        continue
    fi
    if [ ! -e "$ff" ] ; then
        abort=true
        echo "ERROR: $ROSDEP_SOURCE_PATH/20-default.list points to $ff file, which doesn't exist"
        continue
    fi
    # -q reports when they differ.
    diff -q $generated/rosdep/$f.yaml $ff || abort=true
done
unset f ff
if $abort; then
    echo "ABORT: The yaml files pointed to by $ROSDEP_SOURCE_PATH/20-default.list must be local (with file:// URL) and must match those under $generated/rosdep"
    exit 1
fi
unset abort

# Done checking things.

# Keep this block in sync with the one in ros-generate-cache.sh .
echo "Running 'rosdep update'"
rosdep update || { echo "ABORT: 'rosdep update' failed"; exit 1; }
echo "'rosdep update' finished"

tmpdir=$(mktemp -t -d ros-generate-recipes-XXXXXXXX)
trap "rm -rf $tmpdir" 0

cp $generated/index-v4.yaml $tmpdir/
sed -i -e "/$ROS_DISTRO-cache.yaml.gz/ s@: .*\$@: file://$PWD/$generated/cache.yaml@" $tmpdir/index-v4.yaml

# Tell superflore to use this index instead of the upstream one.
export ROSDISTRO_INDEX_URL="file://$tmpdir/index-v4.yaml"
# Have it use this date instead of "now".
export SUPERFLORE_GENERATION_DATETIME="$ROS_ROSDISTRO_COMMIT_DATETIME"

before_commit=$(git rev-list -1 HEAD)
$SUPERFLORE_GEN_OE_RECIPES --dry-run --no-branch --ros-distro $ROS_DISTRO --output-repository-path . --upstream-branch HEAD \
                            $only_option

after_commit=$(git rev-list -1 HEAD)
if [ $after_commit != $before_commit -a -z "$only_option" ]; then
    git add $generated/cache.yaml $generated/cache.diffme

    generated_inc="meta-ros$ROS_VERSION-$ROS_DISTRO/conf/ros-distro/include/$ROS_DISTRO/generated/superflore-ros-distro.inc"
    [ $ROS_DISTRO_RELEASE_DATE = "pre-release" ] && ROS_DISTRO_RELEASE_DATE=""
    cat <<! >> $generated_inc

# From the release announcement or the last field of the "<ROS_DISTRO>/YYYY-MM-DD" tag for the release in
# https://github.com/ros/rosdistro/tags. Prior to the first release of a ROS_DISTRO, it is set to "".
ROS_DISTRO_RELEASE_DATE = "$ROS_DISTRO_RELEASE_DATE"

# The commit of ros/rosdistro/$ROS_DISTRO/distribution.yaml from which the recipes were generated.
ROS_SUPERFLORE_GENERATION_COMMIT = "$ROS_ROSDISTRO_COMMIT"

# Version of scripts/ros-generate-cache.sh which was used to generate cache from which the recipes and this configuration
# file were last generated
ROS_GENERATE_CACHE_PROGRAM_VERSION = "$ROS_GENERATE_CACHE_VERSION"

# Version of scripts/ros-generate-recipes.sh which was used to generate recipes and this configuration file
ROS_GENERATE_RECIPES_PROGRAM_VERSION = "$SCRIPT_VERSION"
!
    git add $generated_inc
    git commit -s --amend -q -C HEAD

    unset generated_inc
fi
