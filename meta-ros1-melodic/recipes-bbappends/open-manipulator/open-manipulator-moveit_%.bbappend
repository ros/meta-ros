# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[open-manipulator-moveit] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'ogre'], 'Requires moveit-ros-visualization which depends on moveit-setup-assistant which depends on qtbase which requires meta-qt5 to be included and depends on moveit-setup-assistant which requires ogre which is not available', '', d)}"
