# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gazebo-rosdev] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on gazebo which is not available', '', d)}"
