# Copyright (c) 2026 Wind River Systems, Inc.

# nav2-velocity-smoother/1.1.20-1/recipe-sysroot/opt/ros/humble/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = geometry_msgs::msg::Twist_<std::allocator<void> >; MessageT = geometry_msgs::msg::Twist_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
