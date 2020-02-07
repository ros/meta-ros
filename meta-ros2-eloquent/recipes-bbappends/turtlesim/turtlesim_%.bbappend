# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[turtlesim] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on qtbase', '', d)}"
