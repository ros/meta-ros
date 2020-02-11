# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[grid-map] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires grid-map-demos which depends on grid-map-rviz-plugin which depends on qtbase which requires meta-qt5 to be included', '', d)}"
