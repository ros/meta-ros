# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_BUILD_DEPENDS += " \
    service-msgs \
    std-msgs \
"
