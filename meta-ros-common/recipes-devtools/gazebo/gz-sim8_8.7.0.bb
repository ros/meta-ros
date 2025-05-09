# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & Artistic-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://src/systems/elevator/vender/afsm/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://src/systems/elevator/vender/metapushkin/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://test/gtest_vendor/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/gazebosim/gz-sim.git;protocol=https;branch=gz-sim8"

SRCREV = "c298007066eb3a0a4b260884fe9a1148903e7bc3"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS += " \
    gz-cmake3 \
    gz-common5 \
    gz-dartsim-vendor \
    gz-fuel-tools9 \
    gz-gui8 \
    gz-math7 \
    gz-msgs10 \
    gz-msgs10-native \
    gz-physics7 \
    gz-plugin2 \
    gz-rendering8 \
    gz-sensors8 \
    gz-transport13 \
    gz-tools2 \
    gz-utils2 \
    protobuf \
    pybind11-vendor \
    sdformat \
"

EXTRA_OECMAKE += " \
    -Dgz-msgs10_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs10_protoc_plugin \
    -Dgz-msgs10_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs10_PYTHON_INTERPRETER=${PYTHON} \
    -Dgz-msgs10_PROTO_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs10_generate.py \
    -Dgz-msgs10_FACTORY_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs10_generate_factory.py \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

# CMake Error at src/gui/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
# Call Stack (most recent call first):
#   src/gui/plugins/modules/CMakeLists.txt:5 (gz_add_gui_library)
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

FILES:${PN} += " \
    ${libdir}/ruby/gz \
    ${libdir}/gz-sim-8 \
    ${datadir}/gz/ \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-sim-8/plugins/lib*${SOLIBSDEV} \
"
