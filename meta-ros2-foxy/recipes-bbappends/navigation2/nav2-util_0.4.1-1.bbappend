# Copyright (c) 2020 LG Electronics, Inc.

# Doesn't seem to be really mandatory
DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"

# nav2-util/0.4.1-1-r0/git/include/nav2_util/service_client.hpp:73:43: error: 'using FutureReturnCode = enum class rclcpp::FutureReturnCode' is deprecated: use rclcpp::FutureReturnCode instead [-Werror=deprecated-declarations]
#   73 |       rclcpp::executor::FutureReturnCode::SUCCESS)
#      |                                           ^~~~~~~
CXXFLAGS += "-Wno-error=deprecated-declarations"
