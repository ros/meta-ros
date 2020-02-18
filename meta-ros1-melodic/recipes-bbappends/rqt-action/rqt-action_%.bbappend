# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-action] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], 'Requires rqt-py-common which requires meta-qt5 to be included and (rqt-msg,rqt-py-common)->python-qt-binding which requires pyqt5', '', d)}"
