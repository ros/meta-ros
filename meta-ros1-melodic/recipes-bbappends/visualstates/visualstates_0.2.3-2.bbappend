# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[visualstates] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires python-qt5-bindings which is not available', '', d)}"
