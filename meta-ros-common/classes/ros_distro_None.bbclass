# Copyright (c) 2020 LG Electronics, Inc.

# This bbclass is just to catch cases where someone tries to build recipe
# inherit-ing ros_distro_${ROS_DISTRO} without ROS_DISTRO variable being set
# e.g. when including only meta-ros-common layer

python() {
    raise bb.parse.SkipRecipe('Requires ROS_DISTRO to be set by one of meta-ros[12]-<release-name> layers')
}
