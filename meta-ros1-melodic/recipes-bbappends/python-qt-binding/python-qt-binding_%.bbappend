# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[python-qt-binding] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires meta-qt5 to be included', '', d)}"
