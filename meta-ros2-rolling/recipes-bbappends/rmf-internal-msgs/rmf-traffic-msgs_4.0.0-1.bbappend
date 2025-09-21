# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://clear-geoemtry-msgs-dependencies-and-remove-pose2d.patch"

ROS_BUILD_DEPENDS += "\
    fastcdr \
    geometry-msgs \
    rosidl-default-runtime \
    rosidl-default-generators \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-cpp \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

ROS_EXEC_DEPENDS += " \
    service-msgs \
"
