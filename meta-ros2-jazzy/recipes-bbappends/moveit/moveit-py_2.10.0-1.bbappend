# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-py contains symlink .so '/usr/lib/libmoveit_py_utils.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libmoveit_py_utils.so"
