# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at ../Qt5Concurrent/Qt5ConcurrentConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at CMakeLists.txt:162 (qt5_wrap_ui):
#  Unknown CMake command "qt5_wrap_ui".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
