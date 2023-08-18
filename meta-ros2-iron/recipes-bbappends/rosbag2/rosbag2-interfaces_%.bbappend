# Copyright (c) 2021 LG Electronics, Inc.

inherit setuptools3-base

ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"
