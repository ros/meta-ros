# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[desktop] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on (rqt-common-plugins,rviz-default-plugins)->qtbase', '', d)}"
