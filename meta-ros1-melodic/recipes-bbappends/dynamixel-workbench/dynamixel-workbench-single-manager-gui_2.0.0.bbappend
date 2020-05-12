# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# CMake Warning at ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/dynamixel-workbench-single-manager-gui/2.0.0-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:19 (find_package)
#
#
# CMake Error at CMakeLists.txt:69 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '', 'cmake_qt5', d)}
