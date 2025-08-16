# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package librealsense2 contains symlink .so '/usr/lib/librealsense2.so' [dev-so]
FILES:${PN}-dev += "${libdir}/librealsense2.so"
