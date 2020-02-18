# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[ros-controllers] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires rqt-joint-trajectory-controller which depends on rqt-gui-py which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and rqt-joint-trajectory-controller->rqt-gui-py->qt-gui->python-pyqt5 which requires pyqt5', '', d)}"
