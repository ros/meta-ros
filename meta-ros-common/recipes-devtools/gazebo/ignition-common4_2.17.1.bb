# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=2e9f68f022747514564aa13818fcb7c6 \
                    file://profiler/src/Remotery/LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = "git://github.com/gazebosim/gz-common.git;protocol=https;branch=ign-common4 \
           file://cleanup-long-deprecated-ifdefs.patch \
           file://missing-cstdint-header.patch \
"

SRCREV = "ade3fa20db31a094388d1fca96bbddaf5eeb262d"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#    FREEIMAGE_RUNS (advanced)
#    FREEIMAGE_RUNS__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += " -DFREEIMAGE_RUNS=1 -DFREEIMAGE_RUNS__TRYRUN_OUTPUT=0"

DEPENDS = " \
    cppcheck-native \
    doxygen-native \
    graphviz-native \
    gts \
    ffmpeg \
    freeimage \
    ignition-cmake2 \
    ignition-math6 \
    ignition-utils1 \
    libtinyxml2 \
    util-linux \
"

FILES:${PN} += " \
    ${datadir}/ignition/ignition-common4/profiler_vis/* \
    ${datadir}/ignition/ignition-common4/ignition-common4.tag.xml \
"

BBCLASSEXTEND = "native nativesdk"
