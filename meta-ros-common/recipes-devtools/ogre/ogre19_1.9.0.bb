# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

DESCRIPTION = "Extensible Modelica-based platform for optimization, simulation and analysis of complex dynamic systems."
HOMEPAGE = "https://ogrecave.github.io/"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=65d1ee510d57bbd05663424f2ff8d660"

# matches with tag v1-9-0
SRCREV = "fbe7b9edaef1e5368061fed89050092023d61d3d"
SRC_URI = "git://github.com/OGRECave/ogre;protocol=https;branch=master \
           file://find-opengl.patch \
           file://remove-samples.patch \
           file://support-arm64.patch \
           file://resolve-link-errors-due-to-incorrect-template-creation.patch \
           file://add-ogre-version-to-filenames.patch"

S = "${WORKDIR}/git"

inherit cmake features_check pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = " \
    boost \
    cppunit \
    freeimage \
    freetype \
    libx11 \
    libxt \
    libxaw \
    ois \
    poco \
    pugixml \
    libtinyxml \
    zziplib \
    zlib \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl libglu', '', d)} \
"

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
    -DOGRE_FULL_RPATH:BOOL=FALSE \
    -DOGRE_BUILD_DOCS:BOOL=TRUE \
    -DOGRE_INSTALL_DOCS:BOOL=TRUE \
    -DOGRE_CONFIG_THREADS:STRING=0 \
    -DOGRE_RESOURCEMANAGER_STRICT:STRING=2 \
    -DOGRE_BUILD_LIBS_AS_FRAMEWORKS:BOOL=OFF \
    -DOGRE_BUILD_COMPONENT_PYTHON:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_JAVA:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_CSHARP:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_BITES:BOOL=FALSE \
"

EXTRA_OECMAKE += "${EXTRA_OECMAKE_RVIZ_OGRE_VENDOR}"

FILES:${PN}-dev += "${libdir}/OGRE19/cmake ${libdir}/OGRE19/*${SOLIBSDEV}"
FILES:${PN} += "${datadir}/OGRE19 ${libdir}/OGRE19"
