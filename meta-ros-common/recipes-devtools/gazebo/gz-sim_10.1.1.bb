# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & Artistic-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://src/systems/elevator/vender/afsm/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://src/systems/elevator/vender/metapushkin/LICENSE;md5=ed0f22fa6f2ee0a77567130e0e8c8d15 \
                    file://test/gtest_vendor/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/gazebosim/gz-sim.git;protocol=https;branch=gz-sim10"

SRCREV = "570d53e5fd7f4852e6f32567f2f4ac3b73b80250"

inherit cmake

DEPENDS += " \
    gz-cmake \
    gz-common \
    gz-dartsim-vendor \
    gz-fuel-tools \
    gz-gui \
    gz-math \
    gz-msgs \
    gz-msgs-native \
    gz-physics \
    gz-plugin \
    gz-rendering \
    gz-sensors \
    gz-transport \
    gz-tools \
    gz-utils \
    libwebsockets \
    protobuf \
    pybind11-vendor \
    qtdeclarative \
    qtdeclarative-native \
    sdformat \
"

EXTRA_OECMAKE += " \
    -Dgz-msgs_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs_protoc_plugin \
    -Dgz-msgs_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs_PYTHON_INTERPRETER=${PYTHON} \
    -Dgz-msgs_PROTO_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs_generate.py \
    -Dgz-msgs_FACTORY_GENERATOR_SCRIPT=${STAGING_BINDIR_NATIVE}/gz-msgs_generate_factory.py \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

FILES:${PN} += " \
    ${datadir}/gz \
    ${libdir}/gz-sim-10 \
    ${libdir}/python/gz \
    ${libdir}/ruby/gz \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-sim-10/plugins/lib*${SOLIBSDEV} \
"
