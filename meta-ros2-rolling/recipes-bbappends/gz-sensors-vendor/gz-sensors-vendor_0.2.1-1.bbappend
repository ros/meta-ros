# Copyright (c) 2024 Wind River Systems, Inc.

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

ROS_BUILD_DEPENDS += "gz-sensors9"
ROS_BUILDTOOL_DEPENDS += "protobuf-native"
