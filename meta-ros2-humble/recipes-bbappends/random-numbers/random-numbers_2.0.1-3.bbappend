# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://replace-deprecated-ament_target_libraries.patch \
            file://fix-declaration-of-include-directories.patch \
            file://fix-propagation-of-boost-random.patch \
            file://fix-link-to-boost-thread.patch"
