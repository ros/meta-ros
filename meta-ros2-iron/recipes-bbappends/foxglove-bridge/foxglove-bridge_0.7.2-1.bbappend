# Copyright (c) 2023 Wind River Systems, Inc.

# foxglove-bridge/0.7.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_value__struct.hpp:208:28: error: comparing floating-point with '==' or '!=' is unsafe [-Werror=float-equal]
CXXFLAGS += "-Wno-error=float-equal"

# foxglove-bridge/0.7.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; MessageT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declaratio
CXXFLAGS += "-Wno-error=deprecated-declarations"

# error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' writing between 9 and 9223372036854775807 bytes into a region of size 8 overflows the destination [-Werror=stringop-overflow=]
CXXFLAGS += "-Wno-error=stringop-overflow"
