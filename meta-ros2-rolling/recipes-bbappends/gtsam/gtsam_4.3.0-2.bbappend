# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause AND MIT AND Apache-2.0 AND MPL-2.0 AND GPL-3.0-or-later AND LGPL-2.1-or-later"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-search-source-tree-for-dataset.patch \
            file://remove-boost-system.patch"

DEPENDS += "boost"

EXTRA_OECMAKE += "-DGTSAM_USE_SYSTEM_EIGEN=ON"

# gtsam/4.3.0-2/recipe-sysroot/usr/include/eigen3/Eigen/src/Core/arch/AVX/PacketMath.h:1289:13: error: unused variable 'r' [-Werror=unused-variable]
CXXFLAGS += "-Wno-error=unused-variable"

# gtsam/4.3.0-2/recipe-sysroot-native/usr/lib/x86_64-oe-linux/gcc/x86_64-oe-linux/16.1.0/include/avxintrin.h:837:24: error: array subscript '__m256d_u[0]' is partly outside array bounds of 'const gtsam::Matrix2 [1]' {aka 'const Eigen::Matrix<double, 2, 2> [1]'} [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# gtsam/4.3.0-2/sources/gtsam-4.3.0-2/gtsam/discrete/DecisionTreeFactor.h:168:32: error: 'virtual gtsam::DiscreteFactor::shared_ptr gtsam::DecisionTreeFactor::operator*(double) const' was hidden [-Werror=overloaded-virtual=]
CXXFLAGS += "-Wno-error=overloaded-virtual"

# gtsam/4.3.0-2/recipe-sysroot/usr/include/eigen3/Eigen/src/Core/CoreEvaluators.h:911:56: error: 'srcEvaluator.Eigen::internal::evaluator<Eigen::Product<Eigen::CwiseBinaryOp<Eigen::internal::scalar_product_op<double, double>, const Eigen::CwiseNullaryOp<Eigen::internal::scalar_constant_op<double>, const Eigen::Matrix<double, -1, 1, 0, 4, 1> >, const Eigen::Block<Eigen::Block<Eigen::Matrix<double, 4, 4, 0, 4, 4>, 4, 1, true>, -1, 1, false> >, Eigen::Map<Eigen::Matrix<double, 1, -1, 1, 1, 4>, 0, Eigen::Stride<0, 0> >, 1> >::<unnamed>.Eigen::internal::product_evaluator<Eigen::Product<Eigen::CwiseBinaryOp<Eigen::internal::scalar_product_op<double, double>, const Eigen::CwiseNullaryOp<Eigen::internal::scalar_constant_op<double>, const Eigen::Matrix<double, -1, 1, 0, 4, 1> >, const Eigen::Block<Eigen::Block<Eigen::Matrix<double, 4, 4, 0, 4, 4>, 4, 1, true>, -1, 1, false> >, Eigen::Map<Eigen::Matrix<double, 1, -1, 1, 1, 4>, 0, Eigen::Stride<0, 0> >, 1>, 4, Eigen::DenseShape, Eigen::DenseShape, double, double>::m_lhs.Eigen::Matrix<double, -1, 1, 0, 4, 1>::<unnamed>.Eigen::PlainObjectBase<Eigen::Matrix<double, -1, 1, 0, 4, 1> >::m_storage.Eigen::DenseStorage<double, 4, -1, 1, 0>::m_data.Eigen::internal::plain_array<double, 4, 0, 32>::array[2]' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"

# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM_UNSTABLE/GTSAM_UNSTABLEConfig.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM/GTSAM-exports.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM/GTSAMConfig.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/include/gtsam/config.h in package gtsam-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${S}##g" ${D}${ros_libdir}/cmake/GTSAM_UNSTABLE/GTSAM_UNSTABLEConfig.cmake
    sed -i -e "s#${S}##g" ${D}${ros_libdir}/cmake/GTSAM/GTSAMConfig.cmake
    sed -i -e "s#${S}##g" ${D}${ros_includedir}/gtsam/config.h
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/cmake/GTSAM/GTSAM-exports.cmake
}

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/opt/ros/rolling/lib/libgtsam.so'
# non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/opt/ros/rolling/lib/libgtsam_unstable.so' [dev-so]
FILES:${PN}-dev =+ "${ros_libdir}/libgtsam*${SOLIBSDEV}"

BBCLASSEXTEND = "native"
