# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-statistics contains symlink .so '/usr/lib/libecl_statistics.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_statistics.so \
"

# not copyrighted stuff
# Setting License from BSD to BSD-3-Clause to be SPDX compliant
LICENSE = "BSD-3-Clause"
