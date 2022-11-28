# Copyright (c) 2022 Wind River Systems, Inc.

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

# nav2-constrained-smoother/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-constrained-smoother/1.1.2-1-r0/git/include/nav2_constrained_smoother/utils.hpp:89:24: error: 'bool ceres::IsInfinite(double)' is deprecated: ceres::IsInfinite will be removed in a future Ceres Solver release. Please use ceres::isinf. [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
