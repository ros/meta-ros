# Copyright (c) 2023 Wind River Systems, Inc.

# QA Issue: non -dev/-dbg/nativesdk- package lanelet2-validation contains symlink .so '/usr/lib/liblanelet2_validation.so' [dev-so]
FILES:${PN}-dev += "${libdir}/liblanelet2_validation.so"
