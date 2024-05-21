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
           file://0001-Fixed-compile-error-2.3.3.patch \
           file://0002-Use_OGRE_NEXT_prefix_for_libraries.patch"

PV = "2.3.3"
SRCREV = "8d4daeaf46d7d8f85f1833f17daedd7dac05daec"

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

EXTRA_OECMAKE += "-DOGRE_USE_NEW_PROJECT_NAME=ON"

FILES:${PN}-dev += "${libdir}/OGRE-Next/cmake ${libdir}/OGRE-Next/*${SOLIBSDEV}"
FILES:${PN} += "${datadir}/OGRE-Next ${libdir}/OGRE-Next"


REQUIRED_DISTRO_FEATURES = "x11"
