# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-chomp contains symlink .so '/usr/lib/libmoveit_chomp_interface.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libmoveit_chomp_interface.so"
