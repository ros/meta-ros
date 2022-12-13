# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-costmap-2d/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated -Wno-error=deprecated-declarations"

# nav2-costmap-2d/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/parameter.hpp:70:21: error: 'transform_tolerance' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"

# error: implicitly-declared 'Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>::Block(const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::BlockImpl<Eigen::Matrix<float, 4, 4>, 1, 4, false, Eigen::Dense>::BlockImpl(const Eigen::BlockImpl<Eigen::Matrix<float, 4, 4>, 1, 4, false, Eigen::Dense>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::internal::BlockImpl_dense<Eigen::Matrix<float, 4, 4>, 1, 4, false, true>::BlockImpl_dense(const Eigen::internal::BlockImpl_dense<Eigen::Matrix<float, 4, 4>, 1, 4, false, true>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::MapBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1>::MapBase(const Eigen::MapBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::MapBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 0>::MapBase(const Eigen::MapBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 0>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'constexpr Eigen::MatrixBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false> >::MatrixBase(const Eigen::MatrixBase<Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false> >&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>::Block(const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>::Block(const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>::Block(const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::BlockImpl<const Eigen::Matrix<float, 3, 1>, 1, 1, false, Eigen::Dense>::BlockImpl(const Eigen::BlockImpl<const Eigen::Matrix<float, 3, 1>, 1, 1, false, Eigen::Dense>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::internal::BlockImpl_dense<const Eigen::Matrix<float, 3, 1>, 1, 1, false, true>::BlockImpl_dense(const Eigen::internal::BlockImpl_dense<const Eigen::Matrix<float, 3, 1>, 1, 1, false, true>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::MapBase<Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>, 0>::MapBase(const Eigen::MapBase<Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>, 0>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'constexpr Eigen::MatrixBase<Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false> >::MatrixBase(const Eigen::MatrixBase<Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false> >&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Transpose<const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false> >::Transpose(const Eigen::Transpose<const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false> >&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'constexpr Eigen::TransposeImpl<const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>, Eigen::Dense>::TransposeImpl(const Eigen::TransposeImpl<const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>, Eigen::Dense>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>::Block(const Eigen::Block<const Eigen::Matrix<float, 3, 1>, 1, 1, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false>::Block(const Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::BlockImpl<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false, Eigen::Dense>::BlockImpl(const Eigen::BlockImpl<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false, Eigen::Dense>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::internal::BlockImpl_dense<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false, true>::BlockImpl_dense(const Eigen::internal::BlockImpl_dense<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false, true>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::MapBase<Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false>, 0>::MapBase(const Eigen::MapBase<Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false>, 0>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'constexpr Eigen::MatrixBase<Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false> >::MatrixBase(const Eigen::MatrixBase<Eigen::Block<const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>, 1, 1, false> >&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>::Block(const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>::Block(const Eigen::Block<Eigen::Matrix<float, 4, 4>, 1, 4, false>&)' is deprecated [-Werror=deprecated-copy]
CXXFLAGS += "-Wno-error=deprecated-copy"
