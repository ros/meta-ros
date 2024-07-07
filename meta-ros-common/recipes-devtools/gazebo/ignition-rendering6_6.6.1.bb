# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0 & OFL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://ogre/src/media/fonts/liberation-sans/SIL%20Open%20Font%20License.txt;md5=a4b00b7892bfb2fc9398e7f292af5b3d"

SRC_URI = "git://github.com/gazebosim/gz-rendering.git;protocol=https;branch=main \
           file://freeimage_optional.patch"

SRCREV = "c2c5fdfb889f449a0c7665dc492ee6b67591cadd"

S = "${WORKDIR}/git"

DEPENDS = "boost"

inherit cmake pkgconfig

# Copied from rviz_ogre_vendor CMakeLists.txt
OGRE_CXX_FLAGS += " \
    -Wno-deprecated-declarations \
    -Wno-mismatched-new-delete \
    -Wno-range-loop-construct \
    -Wno-undef \
    -Wno-misleading-indentation \
    -Wno-implicit-const-int-float-conversion \
"

EXTRA_OECMAKE = " \
    -DSKIP_optix:BOOL=TRUE \
    -DCMAKE_CXX_FLAGS=${OGRE_CXX_FLAGS} \
"

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-math6 \
    ignition-plugin \
    freeimage \
    ogre \
"

OECMAKE_GENERATOR = "Unix Makefiles"

FILES:${PN} += " \
    ${datadir}/ignition/* \
    ${libdir}/ign-rendering-6/engine-plugins/libignition-rendering6-ogre${SOLIBS} \
"

FILES:${PN}-dev += " \
    ${libdir}/ign-rendering-6/engine-plugins/libignition-rendering-ogre.so \
    ${libdir}/ign-rendering-6/engine-plugins/libignition-rendering6-ogre.so \
"

BBCLASSEXTEND = "native nativesdk"
