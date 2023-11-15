# Copyright (c) 2019-2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-libdir.patch"

# This component puts *_proc files under libdir.
FILES:${PN}:prepend = " \
    ${datadir}/lib/${ROS_BPN} \
"

