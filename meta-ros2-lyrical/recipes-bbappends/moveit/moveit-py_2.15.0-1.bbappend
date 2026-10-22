# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

inherit python3targetconfig

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-py contains symlink .so '/usr/lib/libmoveit_py_utils.so' [dev-so]
inherit ros_insane_dev_so
