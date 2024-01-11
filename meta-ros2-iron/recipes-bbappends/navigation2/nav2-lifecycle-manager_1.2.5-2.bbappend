# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-lifecycle-manager/1.1.2-1-r0/recipe-sysroot/usr/include/nav2_msgs/nav2_msgs/srv/detail/manage_lifecycle_nodes__struct.hpp:137:19: error: redundant redeclaration of 'constexpr' static data member 'nav2_msgs::srv::ManageLifecycleNodes_Request_<ContainerAllocator>::STARTUP' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# nav2-lifecycle-manager/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/exceptions/exceptions.hpp:80:81: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNamespaceError' [-Werror=shadow]
# nav2-lifecycle-manager/1.2.5-2-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/exceptions/exceptions.hpp:80:63: error: declaration of 'error_msg' shadows a member of 'rclcpp::exceptions::InvalidNamespaceError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# nav2-lifecycle-manager/1.2.5-2-r0/recipe-sysroot/usr/include/class_loader/class_loader/meta_object.hpp:199:7: error: 'class class_loader::impl::MetaObject<rclcpp_components::NodeFactoryTemplate<nav2_lifecycle_manager::LifecycleManager>, rclcpp_components::NodeFactory>' has virtual functions and accessible non-virtual destructor [-Werror=non-virtual-dtor]
CXXFLAGS += "-Wno-error=non-virtual-dtor"
