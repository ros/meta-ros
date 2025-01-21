# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at rmf-visualization-rviz2-plugins/2.0.2-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

# CMake Error at rmf-visualization-rviz2-plugins/2.0.2-1-r0/recipe-sysroot-native/usr/share/cmake-3.22/Modules/FindPackageHandleStandardArgs.cmake:230 (message):
#   Could NOT find PkgConfig (missing: PKG_CONFIG_EXECUTABLE)
inherit pkgconfig
