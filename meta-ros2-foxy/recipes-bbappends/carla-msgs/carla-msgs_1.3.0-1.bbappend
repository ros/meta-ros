# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    rosidl-default-generators-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_BUILD_DEPENDS:remove = " \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"
