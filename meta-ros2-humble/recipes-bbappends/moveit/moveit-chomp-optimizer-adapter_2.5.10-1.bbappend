# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-chomp-optimizer-adapter contains symlink .so '/usr/lib/libmoveit_chomp_optimizer_adapter.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libmoveit_chomp_optimizer_adapter.so"
