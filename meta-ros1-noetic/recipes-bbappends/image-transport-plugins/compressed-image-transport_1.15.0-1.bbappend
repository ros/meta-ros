# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

# CMake Error at .../compressed-image-transport/1.15.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.22/Modules/FindPackageHandleStandardArgs.cmake:230 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}
