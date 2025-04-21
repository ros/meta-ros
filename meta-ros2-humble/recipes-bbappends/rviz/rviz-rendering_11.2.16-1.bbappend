# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-eigen3-include-dir.patch"

# CMake Warning at /jenkins/mjansa/build/ros/ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/rviz-rendering/8.2.0-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
# SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# ...
# CMake Error at CMakeLists.txt:65 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

ROS_BUILD_DEPENDS += "glew"

# QA Issue: File /opt/ros/humble/share/rviz_rendering/cmake/rviz_renderingExport.cmake in package rviz-rendering-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/rviz_rendering/cmake/rviz_renderingExport.cmake
}
