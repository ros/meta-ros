# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

DESCRIPTION = "Extensible Modelica-based platform for optimization, simulation and analysis of complex dynamic systems."
HOMEPAGE = "https://ogrecave.github.io/"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41bb7e40692720ea7d7b034dc4afd191"

# matches with tag v1.12.12
SRCREV_ogre = "be8c2a225ecae636c8e669a12129b603db6b0e3c"
# matches with tag v1.79
SRCREV_imgui = "e5cb04b132cba94f902beb6186cb58b864777012"
SRCREV_FORMAT = "ogre_imgui"

SRC_URI = "git://github.com/OGRECave/ogre;protocol=https;name=ogre;branch=master \
    git://github.com/ocornut/imgui.git;protocol=https;name=imgui;subdir=imgui;branch=master \
    file://0001-CMakeLists.txt-don-t-set-RPATH.patch \
"

S = "${WORKDIR}/git"

inherit cmake features_check pkgconfig python3native

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = " \
    assimp \
    doxygen \
    freetype \
    freeimage \
    glslang \
    libsdl2 \
    libx11 \
    openexr \
    pugixml \
    spirv-tools \
    swig-native \
    vulkan-headers \
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
    -DOGRE_CONFIG_THREADS:STRING=0 \
    -DOGRE_RESOURCEMANAGER_STRICT:STRING=2 \
    -DOGRE_BUILD_LIBS_AS_FRAMEWORKS:BOOL=OFF \
    -DOGRE_BUILD_COMPONENT_PYTHON:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_JAVA:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_CSHARP:BOOL=FALSE \
    -DOGRE_BUILD_COMPONENT_BITES:BOOL=FALSE \
    -DDOGRE_BUILD_PLUGIN_GLSLANG:BOOL=ON \
    -DOGRE_BUILD_RENDERSYSTEM_GLES2:BOOL=TRUE \
    -DOGRE_GLSUPPORT_USE_EGL=ON \
    -DOGRE_BUILD_RENDERSYSTEM_VULKAN=ON \
    -DOGRE_BUILD_PLUGIN_GLSLANG=ON \
    -DIMGUI_DIR=${WORKDIR}/imgui \
"

EXTRA_OECMAKE += "${EXTRA_OECMAKE_RVIZ_OGRE_VENDOR}"

FILES:${PN}-dev += "${libdir}/OGRE/cmake ${libdir}/OGRE/*${SOLIBSDEV}"
FILES:${PN} += "${datadir}/OGRE ${libdir}/OGRE"
