# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[open-manipulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires open-manipulator-control-gui, open-manipulator-moveit which depends on qtbase which requires meta-qt5 to be included', '', d)}"
