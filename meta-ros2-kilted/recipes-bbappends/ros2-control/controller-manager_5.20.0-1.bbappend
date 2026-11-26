# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022-2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-setuptools-fix-executable.patch \
    file://disable-compiler-options.patch \
"

# exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
# qos_parameters.hpp:57:5: error: missing braces around initializer for 'std::__array_traits<rclcpp::QosPolicyKind, 9>::_Type' {aka 'rclcpp::QosPolicyKind [9]'} [-Werror=missing-braces]
CXXFLAGS += "-Wno-error=shadow -Wno-error=missing-braces"
