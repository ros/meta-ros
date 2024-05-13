# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS:remove = "rmf-building-map-tools-native"
ROS_BUILDTOOL_DEPENDS:remove = "ros2run-native"
ROS_BUILDTOOL_DEPENDS:append = " rmf-building-map-tools"
ROS_BUILDTOOL_DEPENDS:append = " ros2run"
