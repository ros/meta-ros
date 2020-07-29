# Copyright (c) 2019-2020 LG Electronics, Inc.

# Missing license version in package.xml maps it to invalid LGPL-2
# https://github.com/ros2-gbp/orocos_kinematics_dynamics-release/issues/2
LICENSE = "LGPL-2.1"

# there is eigen3-cmake-module-native in ROS_BUILDTOOL_EXPORT_DEPENDS
# but we need target dependency for orocos-kdl users like kdl-parser
# to find it
DEPENDS += "eigen3-cmake-module"
