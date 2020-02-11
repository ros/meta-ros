# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[hector-slam] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', 'Requires libqt4-dev which requires meta-qt4 to be included', '', d)}"
