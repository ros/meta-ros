# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-exceptions contains symlink .so '/usr/lib/libecl_exceptions.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_exceptions.so \
"
