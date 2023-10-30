# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-bt-navigator/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-bt-navigator/1.1.2-1-r0/recipe-sysroot/usr/include/action_msgs/action_msgs/msg/detail/goal_status__struct.hpp:158:18: error: redundant redeclaration of 'constexpr' static data member 'action_msgs::msg::GoalStatus_<ContainerAllocator>::STATUS_UNKNOWN' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# nav2-bt-navigator/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-bt-navigator/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = geometry_msgs::msg::PoseStamped_<std::allocator<void> >; MessageT = geometry_msgs::msg::PoseStamped_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
