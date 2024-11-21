# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/usr/lib/libgtsam.so'
# non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/usr/lib/libgtsam_unstable.so' [dev-so]
inherit ros_insane_dev_so
LICENSE = "BSD-3-Clause & MIT & Apache-2.0 & MPL-2.0 & GPL-3.0-or-later & LGPL-2.1-or-later"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-search-source-tree-for-dataset.patch"

EXTRA_OECMAKE += " -DGTSAM_USE_SYSTEM_EIGEN=ON"
