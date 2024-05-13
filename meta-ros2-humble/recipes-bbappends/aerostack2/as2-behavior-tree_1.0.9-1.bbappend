# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    ament-cmake-ros-native \
"

# ld: cannot find -lGeographicLib: No such file or directory
DEPENDS += "geographiclib"
