# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-dashboard] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires rqt-gui which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and rqt-robot-dashboard->python-qt-binding which requires pyqt5', '', d)}"
