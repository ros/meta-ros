# Copyright (c) 2020 LG Electronics, Inc.

# Uses own archdetect_c_code code in CMakeLists.txt to
# detect architecture based on gcc macros, there are only 4
# available versions:
# prosilica-gige-sdk/1.26.3-1-r0/git$ ls lib
# armv7  i386  ppc  x86_64

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"
COMPATIBLE_MACHINE_x86 = "(.*)"
COMPATIBLE_MACHINE_armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE_armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE_ppc = "(.*)"

GIGE_ARCH_x86-64 = "x86_64"
GIGE_ARCH_x86 = "i386"
GIGE_ARCH_ppc = "ppc"
GIGE_ARCH_armv7a = "armv7"
GIGE_ARCH_armv7ve = "armv7"
EXTRA_OECMAKE += "-DPVAPILIB=${S}/lib/${GIGE_ARCH}/libPvAPI.so"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-debug-searching-PvAPI-library-search-and-.patch"
