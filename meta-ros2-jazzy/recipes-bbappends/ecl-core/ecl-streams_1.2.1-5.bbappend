# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-streams contains symlink .so '/usr/lib/libecl_streams.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_streams.so \
"
