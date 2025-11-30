# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    rosidl-core-generators\
"

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
"

# nav-2d-utils/1.3.5/recipe-sysroot/opt/ros/jazzy/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79:
# error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"
