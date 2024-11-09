# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023-2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

DEPENDS += "catkin"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-embedded-path-in-pyc-files.patch"
