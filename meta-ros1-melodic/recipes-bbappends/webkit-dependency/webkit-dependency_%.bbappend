# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[webkit-dependency] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires python-qt5-bindings-webkit which requires meta-qt5 to be included', '', d)}"
