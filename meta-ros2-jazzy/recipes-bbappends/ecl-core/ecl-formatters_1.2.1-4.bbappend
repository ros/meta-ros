# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-formatters contains symlink .so '/usr/lib/libecl_formatters.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_formatters.so \
"
