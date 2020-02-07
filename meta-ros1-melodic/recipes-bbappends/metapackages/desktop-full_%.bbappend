# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[desktop-full] ?= "${@ 'Requires desktop, simulators which depends on ros-tutorials, rqt-robot-plugins which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
