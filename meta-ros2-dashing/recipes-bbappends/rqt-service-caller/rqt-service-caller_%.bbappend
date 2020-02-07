# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt-service-caller] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'qt5: depends on rqt-gui-py->python-qt-binding->qtbase; pyqt5: depends on rqt-gui-py->rqt-gui->python3-pyqt5 which requires pyqt5', '', d)}"
