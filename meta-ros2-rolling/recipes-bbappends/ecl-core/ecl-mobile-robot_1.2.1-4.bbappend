# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-mobile-robot contains symlink .so '/usr/lib/libecl_mobile_robot.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_mobile_robot.so \
"
