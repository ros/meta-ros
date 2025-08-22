# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    protobuf \
"

ROS_BUILDTOOL_DEPENDS += " \
    protobuf-native \
"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

# CMake Warning at /ala-lpggp31/rwoolley/pr1144/build/tmp-glibc/work/cortexa72-oe-linux/ros-gz-sim/1.0.0-1/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
