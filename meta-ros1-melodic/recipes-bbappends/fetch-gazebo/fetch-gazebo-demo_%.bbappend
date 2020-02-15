# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-gazebo-demo] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires fetch-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and depends on gazebo-fetch which depends on gazebo which is not available', '', d)}"
