# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# QA Issue: non -dev/-dbg/nativesdk- package moveit-ros-visualization contains symlink .so
FILES:${PN}-dev += "${ros_libdir}/liblanelet2_projection.so"
