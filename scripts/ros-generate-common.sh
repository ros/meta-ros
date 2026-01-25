# /bin/sh (deliberately no !#)
#
# This bash script includes common functions/constants used by the following scripts:
# - ros-generate-cache.sh
# - ros-generate-recipes.sh
#

# get_ros_version : return the ROS version based on the distribution or abort if the distribution is not recognized.
# usage :           ROS_VERSION=$(get_ros_version "YOUR DISTRIBUTION")
# example :         ROS_VERSION=$(get_ros_version "eloquent")

function get_ros_version() {
    local ros_distro="$1"
    local ros_version
    case $ros_distro in
        "melodic"|"noetic")
            ros_version="1"
            ;;

        "dashing"|"eloquent"|"foxy"|"galactic"|"humble"|"iron"|"jazzy"|"kilted"|"rolling")
            ros_version="2"
            ;;

        *)  echo "ABORT: Unrecognized ROS_DISTRO: $ros_distro"
            exit 1
            ;;
    esac
    echo "${ros_version}"
}

# check_release_date :  check the release date format and abort if format is incorrect.
# usage :               check_release_date "YOUR RELEASE DATE"
# example :             check_release_date "2026-12-25"

function check_release_date() {
    local release_date="$1"
    case $release_date in
    final|pre-release|[2-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9])
        : OK
        ;;

    *)  echo "ABORT: ROS_DISTRO_RELEASE_DATE not YYYY-MM-DD or 'final' or 'pre-release': '$release_date'"
        exit 1
        ;;
    esac
}

# detect_uncommitted_modifications :    detect uncommitted modifications and abort if any.
# usage :               detect_uncommitted_modifications
# example :             detect_uncommitted_modifications

function detect_uncommitted_modifications() {
    if [ -n "$(git status --porcelain=v1)" ]; then
        echo "ABORT: Uncommitted modifications detected by Git -- perhaps invoke 'git reset --hard'?"
        exit 1
    fi
}

# run_rosdep_update :   run 'rosdep update' command and abort if the command fails.
# usage :               run_rosdep_update
# example :             run_rosdep_update

function run_rosdep_update() {
    echo "Running 'rosdep update'"
    rosdep update || { echo "ABORT: 'rosdep update' failed"; exit 1; }
    echo "'rosdep update' finished"
}
