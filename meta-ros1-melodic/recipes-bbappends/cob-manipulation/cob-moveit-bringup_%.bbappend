# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-moveit-bringup] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires moveit-ros-visualization which depends on moveit-setup-assistant which depends on qtbase which requires meta-qt5 to be included and rdepends on cob-hardware-config which requires gazebo', '', d)}"
