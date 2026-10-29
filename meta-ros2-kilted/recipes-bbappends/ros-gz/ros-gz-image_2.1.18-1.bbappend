# Copyright (c) 2024-2026 Wind River Systems, Inc.

inherit pkgconfig

ROS_BUILDTOOL_DEPENDS += "protobuf-native"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"
