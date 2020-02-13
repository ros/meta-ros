# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[python-qt-binding] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires meta-qt5 to be included and pyqt5 enabled', '', d)}"
