# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[geometry-tutorials] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires turtle-tf, turtle-tf2 which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included', '', d)}"
