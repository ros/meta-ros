# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-gui.git;protocol=https;branch=gz-gui8"

SRCREV = "036df090d5fb9323617ad186156e295a85e38421"

S = "${WORKDIR}/git"

inherit cmake

# CMake Error at src/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

DEPENDS = " \
    cppcheck-native \
    doxygen-native \
    gz-cmake3 \
    gz-common5 \
    gz-math7 \
    gz-msgs10 \
    gz-plugin2 \
    gz-rendering8 \
    gz-tools2 \
    gz-transport13 \
    gz-utils2 \
    protobuf \
    protobuf-native \
    libtinyxml2 \
    qtbase \
    qtquickcontrols2 \
"
DEPENDS:append:class-target = "xserver-xorg"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

do_install:append() {
    # Remove references to the build directory in the Doxygen tagfile
    sed -i -e "s:${S}::g" ${D}${datadir}/gz/gz-gui8/gz-gui8.tag.xml
}

FILES:${PN} += " \
    ${libdir}/gz-gui-8/plugins/* \
    ${libdir}/ruby/gz/* \
    ${datadir}/gz/* \
"

BBCLASSEXTEND = "native nativesdk"
