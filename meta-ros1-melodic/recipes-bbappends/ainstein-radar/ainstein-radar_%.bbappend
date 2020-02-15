# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[ainstein-radar] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires ainstein-radar-rviz-plugins which depends on qtbase which requires meta-qt5 to be included and rdepends on ainstein-radar-gazebo-plugins which requires gazebo', '', d)}"
