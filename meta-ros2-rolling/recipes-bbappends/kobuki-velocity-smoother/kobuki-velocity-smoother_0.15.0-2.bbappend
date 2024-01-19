# Copyright (c) 2022 Wind River Systems, Inc.

# kobuki-velocity-smoother/0.15.0-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = nav_msgs::msg::Odometry_<std::allocator<void> >; MessageT = nav_msgs::msg::Odometry_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
# kobuki-velocity-smoother/0.15.0-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = geometry_msgs::msg::Twist_<std::allocator<void> >; MessageT = geometry_msgs::msg::Twist_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# kobuki-velocity-smoother/0.15.0-2-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/topic_statistics_collector/received_message_period.hpp:174:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
