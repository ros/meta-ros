# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rtabmap-ros] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'vtk-qt'], 'Requires rviz which requires meta-qt5 to be included and depends on rtabmap which requires libvtk-qt which is not available', '', d)}"
