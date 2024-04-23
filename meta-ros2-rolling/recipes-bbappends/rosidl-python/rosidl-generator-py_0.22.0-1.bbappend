# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_EXPORT_DEPENDS += " \
    rosidl-generator-c \
    rosidl-typesupport-c \
    python3-numpy \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Revert-Install-generated-Python-interfaces-in-a-Pyth.patch"

