# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

# Doesn't need build dependency on orocos-kdl use orocos-kdl-vendor
DEPENDS:remove = "orocos-kdl"
ROS_EXEC_DEPENDS:remove = "orocos-kdl"

DEPENDS += "orocos-kdl-vendor"
ROS_EXEC_DEPENDS += "orocos-kdl-vendor"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"
