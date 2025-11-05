# Copyright (c) 2022 Wind River Systems, Inc.

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

# nav2-constrained-smoother/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-constrained-smoother/1.1.2-1-r0/git/include/nav2_constrained_smoother/utils.hpp:89:24: error: 'bool ceres::IsInfinite(double)' is deprecated: ceres::IsInfinite will be removed in a future Ceres Solver release. Please use ceres::isinf. [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# nav2-constrained-smoother/1.1.12-1/recipe-sysroot-native/usr/lib/x86_64-oe-linux/gcc/x86_64-oe-linux/13.2.0/include/emmintrin.h:275:46: error: '*(__m128d*)((char*)&prelast_dir + offsetof(Eigen::Vector2d, Eigen::Matrix<double, 2, 1, 0, 2, 1>::<unnamed>.Eigen::PlainObjectBase<Eigen::Matrix<double, 2, 1, 0, 2, 1> >::<unnamed>.Eigen::MatrixBase<Eigen::Matrix<double, 2, 1, 0, 2, 1> >::<unnamed>.Eigen::DenseBase<Eigen::Matrix<double, 2, 1, 0, 2, 1> >::<unnamed>.Eigen::DenseCoeffsBase<Eigen::Matrix<double, 2, 1, 0, 2, 1>, 3>::<unnamed>.Eigen::DenseCoeffsBase<Eigen::Matrix<double, 2, 1, 0, 2, 1>, 1>::<unnamed>.Eigen::DenseCoeffsBase<Eigen::Matrix<double, 2, 1, 0, 2, 1>, 0>::<unnamed>))' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"
