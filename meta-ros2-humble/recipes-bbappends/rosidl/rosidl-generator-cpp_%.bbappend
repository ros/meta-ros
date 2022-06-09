# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# Fix for Honister release only:
inherit distutils3-base

# it's already in ROS_TEST_DEPENDS, but do_configure fails without
# it even when testing isn't enabled
DEPENDS += "rosidl-runtime-c"

# exported in rosidl_generator_c/cmake/ament_cmake_export_dependencies-extras.cmake
DEPENDS += "rosidl-cmake"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-errors-downstream.patch \
"
