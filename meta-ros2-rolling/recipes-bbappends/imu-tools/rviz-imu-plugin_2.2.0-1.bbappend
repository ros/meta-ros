# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# CMake Warning at TOPDIR/tmp-glibc/work/core2-64-oe-linux/rviz-imu-plugin/2.1.3-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined                                                                                                                                                                             
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
