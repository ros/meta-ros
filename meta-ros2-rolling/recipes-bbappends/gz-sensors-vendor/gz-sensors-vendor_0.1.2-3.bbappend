# Copyright (c) 2024 Wind River Systems, Inc.

export GZ_RELAX_VERSION_MATCH="1"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

ROS_BUILD_DEPENDS += "gz-sensors8"
ROS_BUILDTOOL_DEPENDS += "protobuf-native"
