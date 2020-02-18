# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[visualstates] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires python-qt5-bindings which is not available and python-pyqt5 which requires pyqt5', '', d)}"
