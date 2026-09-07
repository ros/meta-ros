# Copyright (c) 2024-2026 Wind River Systems, Inc.
include gz-msgs_12.0.2.inc

SRC_URI += "file://override-generator-scripts.patch"

SRCREV = "703d291e80e90df00f9ec0c44a9ee1f399939c09"

DEPENDS = "gz-cmake gz-math gz-tools gz-msgs-native libtinyxml2 protobuf protobuf-native ${PN}-native"
DEPENDS += "${PN}-native"
EXTRA_OECMAKE += " \
    -Dgz-msgs_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs_protoc_plugin \
    -Dgz-msgs_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs_PYTHON_INTERPRETER=${PYTHON} \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += " \
    ${datadir}/gz/gz1.completion.d/msgs12.bash_completion.sh \
    ${datadir}/gz/msgs12.yaml \
"
