# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[desktop-full] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires desktop, simulators which depends on ros-tutorials, rqt-robot-plugins which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included', '', d)}"
