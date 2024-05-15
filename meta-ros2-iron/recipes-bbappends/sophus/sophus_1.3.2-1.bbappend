# Copyright (c) 2024 Wind River Systems, Inc.

# error: array subscript '__Float32x4_t[0]' is partly outside array bounds of 'Eigen::internal::plain_matrix_type<Eigen::Product<Eigen::Matrix<float, 2, 2>, Eigen::Matrix<float, 2, 1>, 0>, Eigen::Dense>::type [1]' {aka 'Eigen::Matrix<float, 2, 1> [1]'} [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"
