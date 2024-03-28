# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# bosch-locator-bridge/2.1.5-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: warning: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = nav_msgs::msg::Odometry_<std::allocator<void> >; MessageT = nav_msgs::msg::Odometry_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Wdeprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
