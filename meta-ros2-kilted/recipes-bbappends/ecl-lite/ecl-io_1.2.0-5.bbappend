# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-io contains symlink .so '/usr/lib/libecl_io.so' [dev-so]
inherit ros_insane_dev_so

# Setting LICENSE from BSD to BSD-3-Clause to be SPDX compliant
LICENSE = "BSD-3-Clause"

# handlers.hpp:73:22: error: 'virtual void ecl::Error::operator=(const ecl::ErrorFlag&)' was hidden [-Werror=overloaded-virtual=]
CXXFLAGS += "-Wno-error=overloaded-virtual"
