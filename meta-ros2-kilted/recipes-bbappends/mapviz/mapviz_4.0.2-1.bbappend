# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# CMake Warning at mapviz/2.2.1-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at CMakeLists.txt:117 (qt5_add_resources):
#   Unknown CMake command "qt5_add_resources".
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}
