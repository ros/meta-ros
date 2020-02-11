# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[seed-r7-bringup] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires seed-r7-typef-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', '', d)}"
