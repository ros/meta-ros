# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "MIT & Unknown"
LIC_FILES_CHKSUM = "file://CMake/Templates/DemoLicense.rtf;md5=2711c49576d18cf781ec81aad76f40d6 \
                    file://COPYING;md5=65d1ee510d57bbd05663424f2ff8d660 \
                    file://OgreMain/src/nedmalloc/License.txt;md5=e4224ccaecb14d942c71d31bef20d78c \
                    file://Samples/Media/DeferredShadingMedia/COPYING;md5=e3b8d8073136f13f04ebb6f8b84efba6 \
                    file://Samples/Media/materials/textures/Cubemaps/License.txt;md5=81b3db517e68c27c535791b2276d5ffd \
                    file://Tools/Common/setup/License.rtf;md5=e1311ad52d6fe736b3819ce831a2a595 \
                    file://Tools/MaterialEditor/wxscintilla_1.69.2/src/scintilla/License.txt;md5=d680acd8db69807fdfb587a342690eac \
                    file://Tools/MilkshapeExport/setup/License.rtf;md5=e1311ad52d6fe736b3819ce831a2a595 \
                    file://Tools/XSIExport/setup/License.rtf;md5=e1311ad52d6fe736b3819ce831a2a595"

SRC_URI = "git://github.com/OGRECave/ogre-next.git;protocol=https;branch=master \
           file://0001-Fixed-compile-error-2.2.0.patch \
           file://0001-Neon-is-architectural-for-AArch64.patch \
           file://0001-Fixed-macOS-build.patch \
"

PV = "2.2.0"
SRCREV = "6a814a02e69dfe3c006baf8ec6399aeb611452ca"

S = "${WORKDIR}/git"

inherit cmake features_check pkgconfig

DEPENDS = " \
    cppunit \
    doxygen-native \
    freeimage \
    freetype \
    libsdl2 \
    libx11 \
    libxaw \
    rapidjson \
    renderdoc \
    tbb \
    libtinyxml \
    zlib \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl libglu', '', d)} \
"

FILES:${PN}-dev += "${libdir}/OGRE-Next/cmake ${libdir}/OGRE-Next/*${SOLIBSDEV}"
FILES:${PN} += "${datadir}/OGRE-Next ${libdir}/OGRE-Next"

REQUIRED_DISTRO_FEATURES = "x11"

EXTRA_OECMAKE += " \
    -DOGRE_SIMD_NEON:BOOL=FALSE \
    -DOGRE_SIMD_SSE2:BOOL=FALSE \    
"

do_install:append() {
    # pkgconfig
    sed -i -e "s|/OGRE|/OGRE-Next|g" ${D}${libdir}/pkgconfig/*.pc

    # CMake
    sed -i -e "s|share/OGRE/media|share/OGRE-Next/media|g"  ${D}${libdir}/OGRE/cmake/FindOGRE.cmake
    mv ${D}${libdir}/OGRE/cmake/FindOGRE.cmake ${D}${libdir}/OGRE/cmake/FindOGRE2.cmake

    # Data files
    sed -i -e "s|${datadir}/OGRE|${datadir}/OGRE-Next|g" ${D}${datadir}/OGRE/resources.cfg
    sed -i -e "s|share/OGRE/docs|share/OGRE-Next/docs|g"  ${D}${datadir}/OGRE/docs/CMakeLists.txt

    mv ${D}${datadir}/OGRE ${D}${datadir}/OGRE-Next

    mv ${D}${libdir}/OGRE ${D}${libdir}/OGRE-Next
}
