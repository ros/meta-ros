# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

# orocos-kdl appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "orocos-kdl"
ROS_EXEC_DEPENDS:remove = "orocos-kdl"

DEPENDS:append = "orocos-kdl-vendor"
ROS_EXEC_DEPENDS:append = "orocos-kdl-vendor"
