# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fsrobo-r-moveit-config] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and depends on fsrobo-r-description which depends on gazebo which is not available', '', d)}"
