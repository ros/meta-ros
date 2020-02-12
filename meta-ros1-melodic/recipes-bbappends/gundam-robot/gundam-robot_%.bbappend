# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gundam-robot] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires gundam-rx78-control which requires ros-controllers which depends on rqt-joint-trajectory-controller which depends on rqt-gui-py which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included', '', d)}"
