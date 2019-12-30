# Copyright (c) 2019 LG Electronics, Inc.

# -Werror=return-type is enabled by default in webOS OSE builds, causing:
# sick-scan2/0.1.4-1-r0/git/driver/src/sick_scan_common.cpp: In member function 'int sick_scan::SickScanCommon::loopOnce()':
# sick-scan2/0.1.4-1-r0/git/driver/src/sick_scan_common.cpp:2823:2: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
