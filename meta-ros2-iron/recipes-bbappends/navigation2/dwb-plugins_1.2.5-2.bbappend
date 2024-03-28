# Copyright (c) 2022 Wind River Systems, Inc.

# dwb-plugins/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/dwb-plugins/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# dwb-plugins/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
# dwb-plugins/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:61: error: declaration of 'error_msg' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# dwb-plugins/1.2.5-2-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/moving_average_statistics/moving_average.hpp:49:7: error: 'class libstatistics_collector::moving_average_statistics::MovingAverageStatistics' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
