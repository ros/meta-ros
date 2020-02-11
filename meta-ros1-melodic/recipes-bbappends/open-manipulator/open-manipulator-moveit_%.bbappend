# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[open-manipulator-moveit] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires moveit-ros-visualization which depends on moveit-setup-assistant which depends on qtbase which requires meta-qt5 to be included', '', d)}"
