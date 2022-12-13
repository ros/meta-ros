# Copyright (c) 2022 Wind River Systems, Inc.

# error: conversion to 'int' from 'unsigned int' may change the sign of the result [-Werror=sign-conversion]
# error: conversion to 'long long int' from 'uint64_t' {aka 'long unsigned int'} may change the sign of the result [-Werror=sign-conversion]
# error: conversion to 'long unsigned int' from 'int' may change the sign of the result [-Werror=sign-conversion]
# error: conversion to 'std::__cxx11::basic_string<char>::size_type' {aka 'long unsigned int'} from 'int' may change the sign of the result [-Werror=sign-conversion]
# error: conversion to 'unsigned int' from 'int' may change the sign of the result [-Werror=sign-conversion]
# error: signed conversion from 'unsigned int' to 'int' changes value from '2147483648' to '-2147483648' [-Werror=sign-conversion]
# error: signed conversion from 'unsigned int' to 'int' changes value from '4294967295' to '-1' [-Werror=sign-conversion]
# error: use of old-style cast to 'const double*' [-Werror=old-style-cast]
# error: use of old-style cast to 'const Scalar*' [-Werror=old-style-cast]
#error: use of old-style cast to 'const typename Eigen::internal::unpacket_traits<Packet>::type*' [-Werror=old-style-cast]
# error: use of old-style cast to 'const typename Eigen::internal::unpacket_traits<typename Eigen::internal::conditional<Eigen::internal::gebp_traits<std::complex<_Tp>, std::complex<_Tp>, _ConjLhs, _ConjRhs, Arch, _PacketSize>::Vectorizable, typename Eigen::internal::packet_conditional<_PacketSize, typename Eigen::internal::packet_traits<T>::type, typename Eigen::internal::packet_traits<T>::half, typename Eigen::internal::unpacket_traits<typename Eigen::internal::packet_traits<T>::half>::half>::type, std::complex<_Tp> >::type>::type*' [-Werror=old-style-cast]
# error: use of old-style cast to 'double*' [-Werror=old-style-cast]
# error: use of old-style cast to 'Eigen::internal::SsePrefetchPtrType' {aka 'const char*'} [-Werror=old-style-cast]
# error: use of old-style cast to 'enum Eigen::TransformTraits' [-Werror=old-style-cast]
# error: use of old-style cast to 'int' [-Werror=old-style-cast]
# error: use of old-style cast to 'LinearMatrixType*' [-Werror=old-style-cast]
# error: use of old-style cast to '__m64*' [-Werror=old-style-cast]
# error: use of old-style cast to 'Scalar*' [-Werror=old-style-cast]
# error: use of old-style cast to 'unsigned int' [-Werror=old-style-cast]
CFLAGS += "-Wno-error=sign-conversion -Wno-error=old-style-cast"
CXXFLAGS += "-Wno-error=sign-conversion -Wno-error=old-style-cast"

# error: conversion from 'long unsigned int' to 'int' may change value [-Werror=conversion]
# error: conversion from 'Eigen::Hyperplane<_Scalar, _AmbientDim, Options>::Index' {aka 'long int'} to 'int' may change value [-Werror=conversion]
CFLAGS += " -Wno-error=conversion "
CXXFLAGS += " -Wno-error=conversion "

# error: implicitly-declared 'constexpr Eigen::MatrixBase<Eigen::CwiseNullaryOp<Eigen::internal::scalar_constant_op<double>, const Eigen::Matrix<double, 4, 1> > >::MatrixBase(const Eigen::MatrixBase<Eigen::CwiseNullaryOp<Eigen::internal::scalar_constant_op<double>, const Eigen::Matrix<double, 4, 1> > >&)' is deprecated [-Werror=deprecated-copy]
# error: implicitly-declared 'constexpr Eigen::internal::no_assignment_operator::no_assignment_operator(const Eigen::internal::no_assignment_operator&)' is deprecated [-Werror=deprecated-copy]
CFLAGS += " -Wno-error=deprecated-copy "
CXXFLAGS += " -Wno-error=deprecated-copy "
