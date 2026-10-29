# Copyright (c) 2022 Wind River Systems, Inc.

# dwb-core/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/dwb-core/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# dwb-core/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# dwb-core/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# dwb-core/1.5.1-1/recipe-sysroot/opt/ros/lyrical/include/class_loader/class_loader/meta_object.hpp:59:27: error: 'class class_loader::impl::AbstractMetaObjectBase' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
