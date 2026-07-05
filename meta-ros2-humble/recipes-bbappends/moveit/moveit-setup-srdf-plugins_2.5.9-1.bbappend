# Copyright (c) 2024-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
"

# CMake Warning at moveit-setup-srdf-plugins/2.9.0-2/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at CMakeLists.txt:13 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}
