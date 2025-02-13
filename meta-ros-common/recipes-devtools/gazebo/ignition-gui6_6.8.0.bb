# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-gui.git;protocol=https;branch=ign-gui6"

SRCREV = "982aafca1b96dbc6d12ea5de4d8df27c288be532"

S = "${WORKDIR}/git"

inherit cmake

# CMake Error at src/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-plugin1 \
    ignition-rendering6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    protobuf \
    libtinyxml2 \
    qtbase \
    qtquickcontrols2 \
"
DEPENDS:append:class-target = "xserver-xorg"

FILES:${PN} += " \
    ${libdir}/ign-gui-6/plugins/* \
    ${libdir}/ruby/ignition/* \
    ${datadir}/gz/* \
    ${datadir}/ignition/* \
"

BBCLASSEXTEND = "native nativesdk"
