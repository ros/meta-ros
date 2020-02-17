# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rtabmap] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'vtk-qt'], 'Requires qt-gui-cpp which depends on qtbase which requires meta-qt5 to be included and requires libvtk-qt which is not available', '', d)}"
