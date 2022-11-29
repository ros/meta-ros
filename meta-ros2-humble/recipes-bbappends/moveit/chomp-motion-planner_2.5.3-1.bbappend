# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package chomp-motion-planner contains symlink .so '/usr/lib/libchomp_motion_planner.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libchomp_motion_planner.so"
