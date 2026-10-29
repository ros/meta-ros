# Copyright (c) 2026 Wind River Systems, Inc.

# nav2-mppi-controller/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# nav2-mppi-controller/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# nav2-mppi-controller/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/class_loader/class_loader/meta_object.hpp:59:27: error: 'class class_loader::impl::AbstractMetaObjectBase' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"

# nav2-mppi-controller/1.5.1-1/recipe-sysroot-native/usr/lib/aarch64-oe-linux/gcc/aarch64-oe-linux/16.2.0/include/arm_neon.h:12296:36: error: potential null pointer dereference [-Werror=null-dereference]
CXXFLAGS += "-Wno-error=null-dereference"
