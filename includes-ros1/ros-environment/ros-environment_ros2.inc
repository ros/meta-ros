# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/ros-environment-ros2:"
SRC_URI_append = " \
    file://add-os-override.patch \
"
