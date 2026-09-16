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

# nav2-mppi-controller/1.3.12/recipe-sysroot/opt/ros/spaceros/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: warning: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Wdeprecated-declarations]
CXXFLAGS += " -Wno-error=deprecated-declarations"
