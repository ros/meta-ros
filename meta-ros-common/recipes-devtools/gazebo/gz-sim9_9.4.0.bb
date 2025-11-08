# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & Artistic-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://src/systems/elevator/vender/afsm/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://src/systems/elevator/vender/metapushkin/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://test/gtest_vendor/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/gazebosim/gz-sim.git;protocol=https;branch=gz-sim9"

SRCREV = "e7ef48eb1bb5c2d2981d5da8e286743914d42f84"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS += " \
    gz-cmake4 \
    gz-common6 \
    gz-dartsim-vendor \
    gz-fuel-tools10 \
    gz-gui9 \
    gz-math8 \
    gz-msgs11 \
    gz-msgs11-native \
    gz-physics8 \
    gz-plugin3 \
    gz-rendering9 \
    gz-sensors9 \
    gz-transport14 \
    gz-tools2 \
    gz-utils3 \
    protobuf \
    pybind11-vendor \
    sdformat \
"

EXTRA_OECMAKE += " \
    -Dgz-msgs11_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs11_protoc_plugin \
    -Dgz-msgs11_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs11_PYTHON_INTERPRETER=${PYTHON} \
    -Dgz-msgs11_PROTO_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs11_generate.py \
    -Dgz-msgs11_FACTORY_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs11_generate_factory.py \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

# CMake Error at src/gui/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
# Call Stack (most recent call first):
#   src/gui/plugins/modules/CMakeLists.txt:5 (gz_add_gui_library)
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

FILES:${PN} += " \
    ${libdir}/ruby/gz \
    ${libdir}/gz-sim-9 \
    ${datadir}/gz/ \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-sim-9/plugins/lib*${SOLIBSDEV} \
"
