# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at /ala-lpggp21/rwoolley/ros-image-world/tmp-glibc/work/core2-64-oe-linux/rviz2/11.2.8-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}

ROS_BUILDTOOL_DEPENDS += " \
    ament-package-native \
    rosidl-default-generators-native \
"

# ERROR: QA Issue: package rviz2 contains bad RPATH .../assimp/5.2.5-r0/recipe-sysroot/usr/lib
#        in file .../rviz2/11.2.8-1-r0/packages-split/rviz2/usr/bin/rviz2
EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=ON"
