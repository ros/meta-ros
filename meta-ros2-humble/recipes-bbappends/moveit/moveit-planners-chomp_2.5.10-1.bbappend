# Copyright (c) 2022 Wind River Systems, Inc.
LICENSE = "BSD-3-Clause"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-chomp contains symlink .so '/usr/lib/libmoveit_chomp_interface.so' [dev-so]
FILES:${PN}-dev += "${ros_libdir}/libmoveit_chomp_interface.so"
