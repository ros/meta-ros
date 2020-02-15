# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-simulation] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires fetch-gazebo-demo which depends on fetch-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and rdepends on fetch-gazebo-demo, fetchit-challenge, fetch-gazebo which require gazebo', '', d)}"
