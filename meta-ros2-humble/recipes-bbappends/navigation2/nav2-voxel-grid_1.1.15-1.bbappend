# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    rosidl-adapter-native \
    python3-numpy-native \
"

# nav2-voxel-grid/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant
# redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"
