# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-append-to-CMAKE_CXX_FLAGS-instead-of-.patch \
    file://0002-src-odom_estimation_node.cpp-include-chrono.patch \
"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"
