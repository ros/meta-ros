# Copyright (C) 2025 Wind River Systems, Inc.

# CMake Warning at clearpath-generator-common/1.3.5-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Core/Qt5CoreConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}
