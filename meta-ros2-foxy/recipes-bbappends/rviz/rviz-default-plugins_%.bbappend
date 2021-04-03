# Copyright (c) 2021 LG Electronics, Inc.

# CMake Warning at /jenkins/mjansa/build/ros/ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/rviz-default-plugins/8.2.0-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# ...
# CMake Error at CMakeLists.txt:125 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}
