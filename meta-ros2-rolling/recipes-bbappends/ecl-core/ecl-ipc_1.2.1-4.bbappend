# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-ipc contains symlink .so '/usr/lib/libecl_ipc.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_ipc.so \
"
