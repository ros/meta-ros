# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \ 
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
    rosidl-typesupport-cpp-native \
"

# CMake Warning at TOPDIR/tmp-glibc/work/core2-64-oe-linux/ros-image-to-qimage/0.2.1-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:11 (find_package)
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}
