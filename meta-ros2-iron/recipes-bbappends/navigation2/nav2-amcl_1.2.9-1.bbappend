# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-amcl/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-amcl/1.1.2-1-r0/recipe-sysroot/usr/include/rcl_interfaces/rcl_interfaces/msg/detail/parameter_type__struct.hpp:140:19: error: redundant redeclaration of 'constexpr' static data member 'rcl_interfaces::msg::ParameterType_<ContainerAllocator>::PARAMETER_NOT_SET' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# nav2-amcl/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-amcl/1.1.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = nav_msgs::msg::OccupancyGrid_<std::allocator<void> >; MessageT = nav_msgs::msg::OccupancyGrid_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# nav2-amcl/1.2.5-2-r0/recipe-sysroot/usr/include/class_loader/class_loader/meta_object.hpp:57:27: error: 'class class_loader::impl::AbstractMetaObjectBase' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"

# nav2-amcl/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/create_subscription.hpp:102:14: error: declaration of 'subscription_topic_stats' shadows a previous local [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"
