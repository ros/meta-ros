# Copyright (c) 2025 Wind River Systems, Inc.

# opennav-docking/1.3.5/recipe-sysroot/opt/ros/jazzy/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79:
# error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"
