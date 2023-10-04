# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# CMake Warning at webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/plotjuggler/2.6.2-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:54 (find_package)
#
# -- Can't find Qt5WebSockets in your system. Have you tried [sudo apt-get install libqt5websockets5-dev] ?
# ...
# CMake Error at plotter_gui/CMakeLists.txt:4 (QT5_ADD_RESOURCES):
#   Unknown CMake command "QT5_ADD_RESOURCES".

# but it also needs widgets to be enabled in qtbase PACKAGECONFIG and qtwebsockets
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
