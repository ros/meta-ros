# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://profiler/src/Remotery/LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = "git://github.com/gazebosim/gz-common.git;protocol=https;branch=ign-common4 \
           file://cleanup-long-deprecated-ifdefs.patch \
           file://missing-cstdint-header.patch \
           file://added-missing-includes.patch \
           file://add-missing-cstdint-to-gtest.patch \
"

SRCREV = "60b1fddf05ce020ba7cb79022fdf40be545eb789"

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

do_install:append() {
    # Remove references to the build directory in the Doxygen tagfile
    sed -i -e "s:${S}::g" ${D}${datadir}/ignition/ignition-common4/ignition-common4.tag.xml
}

FILES:${PN} += " \
    ${datadir}/ignition/ignition-common4/profiler_vis/* \
    ${datadir}/ignition/ignition-common4/ignition-common4.tag.xml \
"

BBCLASSEXTEND = "native nativesdk"
