# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-time-lite contains symlink .so '/usr/lib/libecl_time_lite.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_time_lite.so \
"

# Setting LICENSE from BSD to BSD-3-Clause to be SPDX compliant
LICENSE = "BSD-3-Clause"
