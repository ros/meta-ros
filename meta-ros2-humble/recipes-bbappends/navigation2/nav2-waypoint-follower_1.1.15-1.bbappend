# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-waypoint-follower/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-waypoint-follower/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/parameter.hpp:70:21: error: 'timeout' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"

# nav2-waypoint-follower/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-waypoint-follower/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# nav2-waypoint-follower/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-waypoint-follower/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = std_msgs::msg::Empty_<std::allocator<void> >; MessageT = std_msgs::msg::Empty_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
