# Copyright (c) 2020 LG Electronics, Inc.

# nav2-lifecycle-manager/0.4.1-1-r0/git/src/lifecycle_manager_client.cpp:91:41: error: 'using FutureReturnCode = enum class rclcpp::FutureReturnCode' is deprecated: use rclcpp::FutureReturnCode instead [-Werror=deprecated-declarations]
#   91 |     rclcpp::executor::FutureReturnCode::SUCCESS)
#      |                                         ^~~~~~~
CXXFLAGS += "-Wno-error=deprecated-declarations"
