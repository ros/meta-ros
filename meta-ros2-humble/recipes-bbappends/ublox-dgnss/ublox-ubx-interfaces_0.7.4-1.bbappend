# Copyright (c) 2022, Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    rcl-interfaces \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS += " \
    rcl-interfaces \
"

ROS_EXEC_DEPENDS += " \
    rcl-interfaces \
    rosidl-default-runtime \
"
