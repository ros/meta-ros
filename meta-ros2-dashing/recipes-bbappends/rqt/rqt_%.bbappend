# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'qt5: depends on rqt-py-common->qtbase; pyqt5: depends on rqt-gui->python-qt-binding->python3-pyqt5 which requires pyqt5', '', d)}"
