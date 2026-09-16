# Copyright (c) 2025 Wind River Systems, Inc.

# opennav-docking/1.3.5/recipe-sysroot/opt/ros/jazzy/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79:
# error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
