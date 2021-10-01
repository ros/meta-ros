# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-stag_core.patch"

# Disable the check for git lfs installation, there aren't any lfs objects now
ROS_BRANCH:append = ";lfs=0"

inherit pkgconfig
