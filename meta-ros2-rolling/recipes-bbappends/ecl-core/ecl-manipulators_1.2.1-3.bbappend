# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-manipulators contains symlink .so '/usr/lib/libecl_manipulators.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_manipulators.so \
"
