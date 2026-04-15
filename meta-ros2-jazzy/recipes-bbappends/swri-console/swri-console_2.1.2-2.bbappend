# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at TOPDIR/tmp-glibc/work/core2-64-oe-linux/swri-console/2.0.4-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Core/Qt5CoreConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
