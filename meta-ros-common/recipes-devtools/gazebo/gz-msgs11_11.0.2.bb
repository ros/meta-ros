# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs11.inc

SRCREV = "21a942be1223e08c9b42c5aefb29e0414e9ddd2a"

SRC_URI += "file://fix-compatibility-with-protobuf-v30.patch \
            file://update-protobuf-dep.patch \
            file://override-generator-scripts.patch"

DEPENDS = "gz-cmake4 gz-math8 gz-tools2 gz-msgs11-native libtinyxml2 protobuf protobuf-native ${PN}-native"
DEPENDS += "${PN}-native"
EXTRA_OECMAKE += " \
    -Dgz-msgs11_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs11_protoc_plugin \
    -Dgz-msgs11_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs11_PYTHON_INTERPRETER=${PYTHON} \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += " \
    ${datadir}/gz/gz1.completion.d/msgs8.bash_completion.sh \
    ${datadir}/gz/msgs8.yaml \
"
