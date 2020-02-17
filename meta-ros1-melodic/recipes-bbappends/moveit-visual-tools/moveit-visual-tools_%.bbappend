# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[moveit-visual-tools] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'ogre'], 'Requires rviz-visual-tools which depends on rviz which requires meta-qt5 to be included and depends on rviz-visual-tools which depends on ogre which is not available', '', d)}"
