# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# CMake Warning at webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/find-object-2d/0.6.2-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# which without this inherit results in:
# CMake Error at src/CMakeLists.txt:48 (QT5_ADD_RESOURCES):
#   Unknown CMake command "QT5_ADD_RESOURCES".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
