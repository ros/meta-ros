# Copyright (c) 2023 Wind River Systems, Inc.

# exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
# exceptions.hpp:71:61: error: declaration of 'error_msg' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = sensor_msgs::msg::JointState_<std::allocator<void> >; MessageT = sensor_msgs::msg::JointState_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# error: conversion to 'std::streamsize' {aka 'long int'} from 'size_t' {aka 'long unsigned int'} may change the sign of the result [-Werror=sign-conversion]
CXXFLAGS += "-Wno-error=sign-conversion"

# error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
