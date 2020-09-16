# Copyright (c) 2020 LG Electronics, Inc.

# This bbclass is just to catch cases where someone tries to build recipe
# inherit-ing ros_distro_${ROS_DISTRO} without ROS_DISTRO variable being set
# e.g. when including only meta-ros-common layer

python() {
    raise bb.parse.SkipRecipe('Requires ROS_DISTRO to be set by one of meta-ros[12]-<release-name> layers')
}

# ROS_DISTRO_TYPE most likely isn't set as well which will result in another
# parsing error:
# Could not inherit file classes/${ROS_DISTRO_TYPE}_image.bbclass
# Set it to "ros", which will cause metadata common to both ROS 1 and ROS 2
# to be used, eg, classes/ros_image.bbclass will be inherited.
ROS_DISTRO_TYPE ?= "ros"
