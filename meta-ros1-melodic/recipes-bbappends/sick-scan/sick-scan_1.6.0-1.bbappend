# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# sick-scan/1.4.2-1-r0/git/driver/src/dataDumper.cpp:97:1: error: no return statement in function returning non-void [-Werror=return-type]
# sick-scan/1.4.2-1-r0/git/driver/src/sick_scan_common_tcp.cpp:601:3: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-sick_scan_common.cpp-fix-boost-system-error_code-use.patch"
