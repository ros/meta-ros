# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-type-traits contains symlink .so '/usr/lib/libecl_type_traits.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_type_traits.so \
"
