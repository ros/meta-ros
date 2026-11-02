# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += "\
    python3-numpy-native \
"

# rclcpp-components/32.0.0-1/recipe-sysroot/opt/ros/lyrical/include/rcutils/rcutils/logging_macros.h:56:27: error: format not a string literal and no format arguments [-Werror=format-security]
CXXFLAGS += "-Wno-error=format-security"
