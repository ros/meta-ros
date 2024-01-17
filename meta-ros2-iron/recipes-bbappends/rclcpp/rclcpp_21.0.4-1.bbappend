# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-updates-to-net-use-std-move.patch \
    file://0002-add-missing-stdexcept-include.patch \
"

ROS_BUILDTOOL_DEPENDS += " \
    python3-empy-native \
    rcutils-native \
"

