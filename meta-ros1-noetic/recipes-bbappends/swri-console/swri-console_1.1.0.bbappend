# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# swri-console/1.1.0-r0/recipe-sysroot/usr/lib/cmake/Qt5Core/Qt5CoreConfig.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:19 (find_package)
# swri-console/1.1.0-r0/recipe-sysroot/usr/lib/cmake/Qt5Gui/Qt5GuiConfig.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:6 (find_package)
# swri-console/1.1.0-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:7 (find_package)
#
#
# -- Boost version: 1.68.0
# -- Found the following Boost libraries:
# --   chrono
# --   system
# CMake Error at CMakeLists.txt:63 (qt5_add_resources):
#   Unknown CMake command "qt5_add_resources".
inherit ${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '', 'cmake_qt5', d)}
