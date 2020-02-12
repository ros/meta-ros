# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[lvr2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires qtbase which requires meta-qt5 to be included', '', d)}"
