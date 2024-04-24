# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-statistics contains symlink .so '/usr/lib/libecl_statistics.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_statistics.so \
"
