# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[ainstein-radar] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires ainstein-radar-rviz-plugins which depends on qtbase which requires meta-qt5 to be included', '', d)}"
