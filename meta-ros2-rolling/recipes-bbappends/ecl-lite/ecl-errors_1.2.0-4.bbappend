# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-errors contains symlink .so '/usr/lib/libecl_errors.so' [dev-so]
inherit ros_insane_dev_so

# Setting LICENSE from BSD to BSD-3-Clause to be SPDX compliant
LICENSE = "BSD-3-Clause"
