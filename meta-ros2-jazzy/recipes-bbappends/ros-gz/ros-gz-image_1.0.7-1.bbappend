# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += "protobuf-native"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"
