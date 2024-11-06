# Copyright (c) 2022-2024 Wind River Systems, Inc.

# dwb-core/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/dwb-core/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# dwb-core/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/wait_set_template.hpp:544:34: error: declaration of 'std::shared_ptr<void>&& associated_entity' shadows a parameter [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# dwb-core/1.2.5-2-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/moving_average_statistics/moving_average.hpp:49:7: error: 'class libstatistics_collector::moving_average_statistics::MovingAverageStatistics' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
