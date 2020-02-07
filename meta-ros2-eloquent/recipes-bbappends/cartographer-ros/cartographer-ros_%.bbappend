# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cartographer-ros] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cartographer', 'cartographer: depends on cartographer which does not build in ROS2 yet', '', d)}"
