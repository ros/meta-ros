# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[warehouse-ros-mongo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', 'Requires mongodb', '', d)}"
