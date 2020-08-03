# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "ament-cmake-ros-native \
    boost \
    rcutils \
    rcl \
    rosidl-generator-c \
    rosidl-adapter \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Rename-rosidl_runtime_c-to-rosidl_runtime_c.patch"
