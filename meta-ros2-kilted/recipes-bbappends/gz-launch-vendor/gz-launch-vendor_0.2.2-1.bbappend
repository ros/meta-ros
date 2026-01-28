# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    gz-launch8 \
    protobuf \
    protobuf-native \
"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"
