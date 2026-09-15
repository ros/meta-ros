# Copyright (c) 2022-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-chomp contains symlink .so '/usr/lib/libmoveit_chomp_interface.so' [dev-so]
inherit ros_insane_dev_so
