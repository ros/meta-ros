# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "\
    action-msgs \
    fastcdr \
    rosidl-default-runtime \
    rosidl-default-generators \
    rosidl-generator-c \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-cpp \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_EXEC_DEPENDS += " \
    service-msgs \
"
