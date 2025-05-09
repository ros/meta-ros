# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://profiler/src/Remotery/LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = "git://github.com/gazebosim/gz-common.git;protocol=https;branch=gz-common6 \
           file://add-missing-includes.patch"

SRCREV = "1deb6d9e6cbeb28d7def20167c3d3146edd71633"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#    FREEIMAGE_RUNS (advanced)
#    FREEIMAGE_RUNS__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += " -DFREEIMAGE_RUNS=1 -DFREEIMAGE_RUNS__TRYRUN_OUTPUT=0"

DEPENDS = " \
    assimp \
    cppcheck-native \
    doxygen-native \
    gdal \
    graphviz-native \
    gz-cmake4 \
    gz-math8 \
    gz-utils3 \
    gts \
    ffmpeg \
    freeimage \
    libtinyxml2 \
    util-linux \
"

FILES:${PN} += " \
    ${datadir}/gz/gz-common6/profiler_vis/* \
"

BBCLASSEXTEND = "native nativesdk"
