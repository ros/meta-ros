# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[neonavigation] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires neonavigation-launch which depends on trajectory-tracker-rviz-plugins which depends on qtbase which requires meta-qt5 to be included', '', d)}"
