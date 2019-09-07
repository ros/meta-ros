# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/cartographer-ros:"
SRC_URI += " \
    file://cmake.dont.add.isystem.patch \
"

# This is used only to generate documentation so it should
# be native and needs quite a lot of native python dependencies
ROS_BUILD_DEPENDS_remove = "${PYTHON_PN}-sphinx"
