# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at octomap-rviz-plugins/2.0.0-3-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at CMakeLists.txt:25 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
