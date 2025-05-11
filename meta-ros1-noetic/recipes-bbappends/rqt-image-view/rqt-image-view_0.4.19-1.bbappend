# Copyright (c) 2025 Wind River Systems, Inc.

# CMake Warning at .../rqt-image-view/0.4.18-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}
