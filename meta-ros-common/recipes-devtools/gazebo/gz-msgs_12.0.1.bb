# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs_12.0.1.inc

SRC_URI += "file://override-generator-scripts.patch"

SRCREV = "a5576425f1a3d9f736e6758005696aac32f93461"

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
