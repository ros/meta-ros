# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CmakeLists.txt-set-C-version-to-C-14.patch"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS_remove = "ceres-solver"
