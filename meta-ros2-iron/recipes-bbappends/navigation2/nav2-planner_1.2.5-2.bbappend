# Copyright (c) 2022 Wind River Systems, Inc.

# nav2-planner/1.1.2-1-r0/temp/log.do_compile:/ala-lpggp31/rwoolley/meta-ros-update/tmp-glibc/work/core2-64-oe-linux/nav2-planner/1.1.2-1-r0/recipe-sysroot/usr/include/action_msgs/action_msgs/srv/detail/cancel_goal__struct.hpp:263:18: error: redundant redeclaration of 'constexpr' static data member 'action_msgs::srv::CancelGoal_Response_<ContainerAllocator>::ERROR_NONE' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# error: 'expected_planner_frequency' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"
