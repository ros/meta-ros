# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-threads contains symlink .so '/usr/lib/libecl_threads.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_threads.so \
"
