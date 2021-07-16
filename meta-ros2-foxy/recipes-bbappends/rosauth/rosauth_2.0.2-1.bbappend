# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
"
ROS_BUILD_DEPENDS:remove = " \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-fastrtps-c \
"
