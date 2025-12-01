# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://performance-improvement-using-eigen.patch"

# Remove xsimd and xtensor as eigen is now used instead
ROS_BUILD_DEPENDS:remove = "xsimd"
ROS_BUILD_DEPENDS:remove = "xtensor"
ROS_EXPORT_DEPENDS:remove = "xsimd"
ROS_EXPORT_DEPENDS:remove = "xtensor"
ROS_EXEC_DEPENDS:remove = "xsimd"
ROS_EXEC_DEPENDS:remove = "xtensor"
