# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# ld: cannot find -lGeographicLib: No such file or directory
DEPENDS += "geographiclib"
