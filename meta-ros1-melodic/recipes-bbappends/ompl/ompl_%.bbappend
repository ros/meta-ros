# Copyright (c) 2019-2020 LG Electronics, Inc.

inherit ros_insane_dev_so

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-compilation-fix-for-boost-1.71.patch \
"
