# Copyright (c) 2025 Wind River Systems, Inc.

# kinematics-interface/1.6.0/recipe-sysroot/opt/ros/jazzy/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79:
# error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"
