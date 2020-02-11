# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[turtle-tf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires turtlesim which depends on qtbase which requires meta-qt5 to be included', '', d)}"
