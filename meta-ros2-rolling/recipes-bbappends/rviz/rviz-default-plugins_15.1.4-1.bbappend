# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-generators-native \
"
#
# CMake Error at CMakeLists.txt:134 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

