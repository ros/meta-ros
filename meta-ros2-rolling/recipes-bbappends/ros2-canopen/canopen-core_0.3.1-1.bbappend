# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-rclcpp-include-dir.patch \
            file://fix-boost-target.patch"
