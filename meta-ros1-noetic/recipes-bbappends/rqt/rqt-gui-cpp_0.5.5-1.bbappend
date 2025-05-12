# Copyright (c) 2025 Wind River Systems, Inc.

# CMake Warning at TOPDIR/tmp-glibc/work/cortexa76-oe-linux/rqt-gui-cpp/0.5.4-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
#
# CMake Error at CMakeLists.txt:24 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '', 'cmake_qt5', d)}
