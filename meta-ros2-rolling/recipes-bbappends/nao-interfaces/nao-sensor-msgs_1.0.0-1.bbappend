# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022-2023 Wind River Systems, Inc.

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
