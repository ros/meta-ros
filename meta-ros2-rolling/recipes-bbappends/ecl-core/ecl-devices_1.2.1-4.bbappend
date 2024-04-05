# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-devices contains symlink .so '/usr/lib/libecl_devices.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_devices.so \
"
