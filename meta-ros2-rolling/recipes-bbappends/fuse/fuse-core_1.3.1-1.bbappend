# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LICENSE = "BSD-3-Clause"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

SRC_URI:append = " \
    file://0001-fuse_core.patch \
    file://0002-fuse-core-add-missing-boost-add_const-include-for-Bo.patch \
"

inherit pkgconfig

ROS_BUILDTOOL_DEPENDS += "\
  ament-cmake-ros-native \
  ament-cmake-gmock \
  ament-cmake-gtest \
"
