# Copyright (c) 2025 Wind River Systems, Inc.

# nav2-util/1.3.5/recipe-sysroot/opt/ros/jazzy/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79:
# error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# nav2-util/1.3.5/recipe-sysroot/opt/ros/jazzy/include/libstatistics_collector/libstatistics_collector/moving_average_statistics/moving_average.hpp:49:7:
# error: 'class libstatistics_collector::moving_average_statistics::MovingAverageStatistics' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
