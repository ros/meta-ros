# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-io contains symlink .so '/usr/lib/libecl_io.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_io.so \
"
