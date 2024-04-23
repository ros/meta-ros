# Copyright (c) 2024 Rethink Robotics GmbH

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://0001-ignore_uncrustify_version_suffix.patch"

ROS_BUILDTOOL_DEPENDS += " \
    uncrustify-native \
"
