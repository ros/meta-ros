# Copyright (c) 2025 Wind River Systems, Inc.

# CMake Warning at /ala-lpggp31/rwoolley/pr1144/build/tmp-glibc/work/cortexa72-oe-linux/ros-ign-gazebo/0.244.16-2/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}

DEPENDS += " \
    protobuf \
    protobuf-native \
"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

