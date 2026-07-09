# Copyright (c) 2024 Wind River Systems, Inc.

inherit python3targetconfig

ROS_BUILD_DEPENDS += " \
    rosidl-runtime-c \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
