# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & Artistic-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://src/systems/elevator/vender/afsm/LICENSE;md5=ec4341a201f4b801aba0191a5d2d8f39 \
                    file://src/systems/elevator/vender/metapushkin/LICENSE;md5=ec4341a201f4b801aba0191a5d2d8f39"

SRC_URI = "git://github.com/gazebosim/gz-sim.git;protocol=https;branch=ign-gazebo6 \
           file://add-include-algorithm.patch"

SRCREV = "d9b18d85a17400d32494bca4c3589f519aca7e81"

S = "${WORKDIR}/git"

inherit cmake python3native

# CMake Error at src/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-fuel-tools7 \
    ignition-gui6 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-physics5 \
    ignition-plugin1 \
    ignition-rendering6 \
    ignition-sensors6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    protobuf \
    protobuf-native \
    sdformat \
"

RPROVIDES:${PN} += " gazebo"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

PACKAGES =+ "python3-${PN}"

FILES:${PN} += " \
    ${datadir}/ignition/* \
    ${datadir}/gz/gz1.completion.d \
    ${libdir}/ign-gazebo-6/plugins/libignition-gazebo*${SOLIBS} \
    ${libdir}/ign-gazebo-6/plugins/libignition-gazebo*${SOLIBSDEV} \
    ${libdir}/ign-gazebo-6/plugins/gui/lib*${SOLIBSDEV} \
    ${libdir}/ign-gazebo-6/plugins/gui/IgnGazebo \
    ${libdir}/ruby/ignition/ \
"

FILES:python3-${PN} += " \
    ${libdir}/python \
"

BBCLASSEXTEND = "native nativesdk"

inherit ros_insane_dev_so
