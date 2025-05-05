# Copyright (c) 2024 Wind River Systems, Inc.
include gz-msgs10.inc

SRCREV = "3c0ca9455a9686d71c4d7819417e434ae1b47ad6"

DEPENDS = "gz-math7 gz-cmake3 gz-utils2 gz-msgs10-native libtinyxml2 protobuf protobuf-native ${PN}-native"
DEPENDS += "${PN}-native"
EXTRA_OECMAKE += " \
    -Dgz-msgs10_PROTO_GENERATOR_PLUGIN=${STAGING_BINDIR_NATIVE}/gz-msgs10_protoc_plugin \
    -Dgz-msgs10_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -Dgz-msgs10_PYTHON_INTERPRETER=${PYTHON} \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += " \
    ${datadir}/gz/gz1.completion.d/msgs10.bash_completion.sh \
    ${datadir}/gz/msgs10.yaml \
"
