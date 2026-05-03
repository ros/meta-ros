# Copyright (c) 2021 LG Electronics, Inc.

LICENSE = "BSD-3-Clause"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

ROS_BUILDTOOL_DEPENDS:append = " \
    ament-cmake-ros-core-native \
"
