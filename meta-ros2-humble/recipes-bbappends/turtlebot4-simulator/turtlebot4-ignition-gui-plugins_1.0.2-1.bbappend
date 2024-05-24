# Copyright (c) 2023-2024 Wind River Systems, Inc.

# CMake Warning at turtlebot4-ignition-gui-plugins/1.0.2-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

ROS_BUILDTOOL_DEPENDS:remove = "ignition-gui6-native"
ROS_BUILD_DEPENDS:append = "ignition-gui6"
