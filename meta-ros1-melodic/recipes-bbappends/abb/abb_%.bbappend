# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[abb] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires abb-irb6640-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', '', d)}"
