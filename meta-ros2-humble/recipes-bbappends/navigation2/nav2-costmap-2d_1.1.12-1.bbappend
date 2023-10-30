# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-costmap-2d/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated -Wno-error=deprecated-declarations"

# nav2-costmap-2d/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/parameter.hpp:70:21: error: 'transform_tolerance' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"
