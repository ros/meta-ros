# Copyright (c) 2023 Wind River Systems, Inc.

# foxglove-bridge/0.7.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_value__struct.hpp:208:28: error: comparing floating-point with '==' or '!=' is unsafe [-Werror=float-equal]
CXXFLAGS += "-Wno-error=float-equal"

# foxglove-bridge/0.7.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; MessageT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declaratio
CXXFLAGS += "-Wno-error=deprecated-declarations"

# foxglove-bridge/0.7.3-1-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/topic_statistics_collector/received_message_period.hpp:174:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
