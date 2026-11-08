# Copyright (c) 2023-2026 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"
 
ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"
