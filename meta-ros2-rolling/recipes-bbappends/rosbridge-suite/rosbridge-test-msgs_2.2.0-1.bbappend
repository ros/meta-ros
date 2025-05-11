# Copyright (c) 2021 LG Electronics, Inc.

LICENSE = "BSD-3-Clause"

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"
# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    action-msgs \
    rosidl-generator-c \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"
ROS_BUILD_DEPENDS:remove = " \
    rosidl-default-generators \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"
