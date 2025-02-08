# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-gui.git;protocol=https;branch=gz-gui9"

SRCREV = "d110e5b288e8b580b28c0a7256d0e1f0e0c402e2"

S = "${WORKDIR}/git"

inherit cmake

# CMake Error at src/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

DEPENDS = " \
    cppcheck-native \
    doxygen-native \
    gz-cmake4 \
    gz-common6 \
    gz-math8 \
    gz-msgs11 \
    gz-plugin3 \
    gz-rendering9 \
    gz-tools2 \
    gz-transport14 \
    gz-utils3 \
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

FILES:${PN} += " \
    ${libdir}/gz-gui-9/plugins/* \
    ${libdir}/ruby/gz/* \
    ${datadir}/gz/* \
"

BBCLASSEXTEND = "native nativesdk"
