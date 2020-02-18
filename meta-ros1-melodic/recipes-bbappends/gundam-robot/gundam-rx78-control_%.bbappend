# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gundam-rx78-control] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires ros-controllers which depends on rqt-joint-trajectory-controller which depends on rqt-gui-py which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and ros-controllers->rqt-joint-trajectory-controller->rqt-gui-py->qt-gui->python-pyqt5 which requires pyqt5', '', d)}"
