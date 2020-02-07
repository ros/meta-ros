# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gazebo-ros] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on gazebo-rosdev->gazebo which is not available', '', d)}"
