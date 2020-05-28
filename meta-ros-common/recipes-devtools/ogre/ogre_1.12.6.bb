# Copyright (c) 2020 LG Electronics, Inc.

DESCRIPTION = "Extensible Modelica-based platform for optimization, simulation and analysis of complex dynamic systems."
HOMEPAGE = "https://ogrecave.github.io/"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41bb7e40692720ea7d7b034dc4afd191"

# matches with tag 1.12.6
SRCREV = "c1ead4007d6f5552bacd9934a289e4f78b8ecbc2"
SRC_URI = "git://github.com/OGRECave/ogre;protocol=https \
    file://0001-CMakeLists.txt-don-t-set-RPATH.patch \
"

S = "${WORKDIR}/git"

inherit cmake features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = "zlib libx11 pugixml"

# extra flags from rviz-ogre-vendor ExternalProject_Add in:
# https://github.com/ros2/rviz/blob/16ad728224246ac8361e7073e1c89baec5a0eaf1/rviz_ogre_vendor/CMakeLists.txt#L162
EXTRA_OECMAKE_RVIZ_OGRE_VENDOR = " \
    -DOGRE_STATIC:BOOL=OFF \
    -DOGRE_INSTALL_PDB:BOOL=OFF \
    -DOGRE_BUILD_DEPENDENCIES:BOOL=OFF \
    -DOGRE_BUILD_TESTS:BOOL=OFF \
    -DOGRE_BUILD_SAMPLES:BOOL=FALSE \
    -DOGRE_INSTALL_SAMPLES:BOOL=FALSE \
    -DOGRE_INSTALL_SAMPLES_SOURCE:BOOL=FALSE \
    -DOGRE_CONFIG_THREADS:STRING=0 \
    -DOGRE_RESOURCEMANAGER_STRICT:STRING=2 \
    -DOGRE_BUILD_LIBS_AS_FRAMEWORKS:BOOL=OFF \
    -DOGRE_BUILD_COMPONENT_PYTHON:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_JAVA:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_CSHARP:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_BITES:BOOL=FALSE \
"

EXTRA_OECMAKE += "${EXTRA_OECMAKE_RVIZ_OGRE_VENDOR}"

FILES_${PN}-dev += "${libdir}/OGRE/cmake ${libdir}/OGRE/*${SOLIBSDEV}"
FILES_${PN} += "${datadir}/OGRE ${libdir}/OGRE"
