# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fsrobo-r] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires fsrobo-r-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', '', d)}"
