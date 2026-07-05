# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-py contains symlink .so '/usr/lib/libmoveit_py_utils.so' [dev-so]
inherit ros_insane_dev_so
