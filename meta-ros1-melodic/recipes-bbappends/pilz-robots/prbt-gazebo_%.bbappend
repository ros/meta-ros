# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[prbt-gazebo] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires prbt-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included and rdepends on gazebo-ros, gazebo-ros-control which requires gazebo', '', d)}"
