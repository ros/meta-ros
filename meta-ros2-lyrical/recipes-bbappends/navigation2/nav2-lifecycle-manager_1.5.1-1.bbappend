# Copyright (c) 2026 Wind River Systems, Inc.

# nav2-lifecycle-manager/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# nav2-lifecycle-manager/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# nav2-lifecycle-manager/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/class_loader/class_loader/meta_object.hpp:57:27: error: 'class class_loader::impl::AbstractMetaObjectBase' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
