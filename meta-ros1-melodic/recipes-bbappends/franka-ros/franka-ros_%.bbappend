# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[franka-ros] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'ogre'], 'Requires panda-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and depends on panda-moveit-config which depends on moveit-ros-visualization which depends on ogre which is not available', '', d)}"
