# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022, Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter-native \
    rosidl-cmake-native \
    rosidl-parser-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"
