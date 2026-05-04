# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0 & OFL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://ogre/src/media/fonts/liberation-sans/SIL%20Open%20Font%20License.txt;md5=a4b00b7892bfb2fc9398e7f292af5b3d"

SRC_URI = "git://github.com/gazebosim/gz-rendering.git;protocol=https;branch=gz-rendering10 \
           file://support_legacy_opengl.patch"

SRCREV = "c2c809fae72994da8176af70a81085223b7b8cfb"

DEPENDS = " \
    boost \
    freeglut \
    freeimage \
    glew \
    gz-cmake \
    gz-common \
    gz-math \
    gz-plugin \
    gz-utils \
    libglu \
    libxi \
    libxmu \
    ogre \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl libglu', '', d)} \
"

inherit cmake pkgconfig

# Copied from rviz_ogre_vendor CMakeLists.txt
CXXFLAGS += " \
    -Wno-deprecated-declarations \
    -Wno-mismatched-new-delete \
    -Wno-range-loop-construct \
    -Wno-undef \
    -Wno-misleading-indentation \
    -Wno-implicit-const-int-float-conversion \
"

EXTRA_OECMAKE = " \
    -DSKIP_optix:BOOL=TRUE \
"

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#    FREEIMAGE_RUNS (advanced)
#    FREEIMAGE_RUNS__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += " -DFREEIMAGE_RUNS=1 -DFREEIMAGE_RUNS__TRYRUN_OUTPUT=0"

OECMAKE_GENERATOR = "Unix Makefiles"

FILES:${PN} += " \
    ${datadir}/gz/* \
    ${libdir}/gz-rendering-10/engine-plugins/lib*${SOLIBS} \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-rendering-10/engine-plugins/lib*${SOLIBSDEV} \
"

BBCLASSEXTEND = "native nativesdk"
