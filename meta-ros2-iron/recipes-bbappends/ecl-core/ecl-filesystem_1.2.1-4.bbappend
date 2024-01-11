# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-filesystem contains symlink .so '/usr/lib/libecl_filesystem.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_filesystem.so \
"
