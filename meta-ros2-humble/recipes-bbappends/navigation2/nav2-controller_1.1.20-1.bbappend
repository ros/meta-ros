# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-controller/1.1.20-1/recipe-sysroot/opt/ros/humble/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = nav2_msgs::msg::SpeedLimit_<std::allocator<void> >; MessageT = nav2_msgs::msg::SpeedLimit_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
