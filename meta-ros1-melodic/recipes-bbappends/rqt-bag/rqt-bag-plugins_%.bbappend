# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-bag-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires rqt-gui-py which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and depends on unavailable UNRESOLVED-python-cairo', '', d)}"
