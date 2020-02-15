# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-manipulation] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires cob-moveit-bringup which depends on moveit-ros-visualization which depends on moveit-setup-assistant which depends on qtbase which requires meta-qt5 to be included and rdepends on cob-grasp-generation which requires gazebo', '', d)}"
