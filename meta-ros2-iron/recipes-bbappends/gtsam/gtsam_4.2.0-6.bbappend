# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/usr/lib/libgtsam.so'
# non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/usr/lib/libgtsam_unstable.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libgtsam.so ${libdir}/libgtsam_unstable.so"
