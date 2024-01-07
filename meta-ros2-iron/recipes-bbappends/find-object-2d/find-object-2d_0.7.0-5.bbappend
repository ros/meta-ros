# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# CMake Error at src/CMakeLists.txt:55 (QT5_ADD_RESOURCES):
#   Unknown CMake command "QT5_ADD_RESOURCES".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
