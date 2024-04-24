# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"
ROS_BUILD_DEPENDS:remove = " \
    rosidl-default-generators \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    service-msgs \
"
