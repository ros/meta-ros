# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gundam-robot] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires gundam-rx78-control which requires ros-controllers which depends on rqt-joint-trajectory-controller which depends on rqt-gui-py which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and rdepends on gundam-rx78-gazebo which requires gazebo', '', d)}"
