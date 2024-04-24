# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-time contains symlink .so '/usr/lib/libecl_time.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_time.so \
"
