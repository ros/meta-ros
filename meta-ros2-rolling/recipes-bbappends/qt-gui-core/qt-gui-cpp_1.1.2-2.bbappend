# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# | -- Found PythonLibs: ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/lib/libpython3.8.so (found suitable version "3.8.2", minimum required is "3.8")
# | CMake Warning at ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
# |   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# | Call Stack (most recent call first):
# |   src/qt_gui_cpp/CMakeLists.txt:3 (find_package)
# |
# |
# | CMake Error at src/qt_gui_cpp/CMakeLists.txt:35 (qt5_wrap_cpp):
# |   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

# | CMake Warning at ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/share/python_qt_binding/cmake/sip_helper.cmake:27 (message):
# |   SIP binding generator NOT available.
DEPENDS += "sip3-native"
