# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[qt-gui-core] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires qt-gui-py-common which requires meta-qt5 to be included and qt-gui(-cpp)->python-qt-binding which requires pyqt5', '', d)}"
