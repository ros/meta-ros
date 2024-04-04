# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-errors contains symlink .so '/usr/lib/libecl_errors.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_errors.so \
"
