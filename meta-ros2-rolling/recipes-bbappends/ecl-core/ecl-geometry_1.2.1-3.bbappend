# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-geometry contains symlink .so '/usr/lib/libecl_geometry.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_geometry.so \
"
