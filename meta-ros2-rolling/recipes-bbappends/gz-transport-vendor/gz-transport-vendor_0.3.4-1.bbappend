# Copyright (c) 2024 Wind River Systems, Inc.

inherit pkgconfig

ROS_BUILD_DEPENDS += "\
    gz-transport14 \
    protobuf \
"

# meta-zenoh does not support Kirkstone
ROS_EXEC_DEPENDS:remove = "zenoh-cpp-vendor"
ROS_BUILD_DEPENDS:remove = "zenoh-cpp-vendor"

ROS_BUILDTOOL_DEPENDS += "\
    protobuf-native \
    cppcheck-native \
"

EXTRA_OECMAKE += "\
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"
