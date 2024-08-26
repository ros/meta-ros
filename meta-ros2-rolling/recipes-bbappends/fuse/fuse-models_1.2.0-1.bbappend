# Copyright (c) 2021 LG Electronics, Inc.

# fuse-models/0.4.2-1-r0/recipe-sysroot/usr/include/eigen3/Eigen/src/Core/products/SelfadjointMatrixVector.h:227:7: error: 'result' may be used uninitialized [-Werror=maybe-uninitialized]
# CXXFLAGS += "-Wno-error=maybe-uninitialized"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"
