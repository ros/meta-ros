# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-missing-include-for-gcc15.patch"

inherit python3native

ROS_BUILD_DEPENDS += " \
  ament-cmake-ros \
  ament-cmake-gmock \
  ament-cmake-gtest \
  ament-cmake-pytest \
"

ROS_BUILDTOOL_DEPENDS += " \
  python3-numpy-native \
  rosidl-adapter-native \
  rosidl-generator-c-native \
  rosidl-generator-cpp-native \
  rosidl-generator-py-native \
  rosidl-typesupport-c-native \
  rosidl-typesupport-cpp-native \
  rosidl-typesupport-fastrtps-c-native \
  rosidl-typesupport-fastrtps-cpp-native \
"
