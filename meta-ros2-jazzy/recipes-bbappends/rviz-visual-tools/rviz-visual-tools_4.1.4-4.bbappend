# Copyright (c) 2023 Wind River Systems, Inc.

# Could NOT find PkgConfig (missing: PKG_CONFIG_EXECUTABLE)
inherit pkgconfig

# CMake Warning at rviz-visual-tools/4.1.4-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
