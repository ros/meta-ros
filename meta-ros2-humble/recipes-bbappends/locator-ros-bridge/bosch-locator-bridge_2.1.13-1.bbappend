# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
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

# bosch-locator-bridge/2.1.5-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: warning: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = nav_msgs::msg::Odometry_<std::allocator<void> >; MessageT = nav_msgs::msg::Odometry_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Wdeprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-missing-dependencies.patch"
