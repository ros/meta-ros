# Copyright (c) 2020 LG Electronics, Inc.

# -Werror=return-type is enabled by default in webOS OSE builds, causing:
# sick-scan2/0.1.7-1-r0/git/driver/src/sick_scan_common.cpp:2827:2: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
