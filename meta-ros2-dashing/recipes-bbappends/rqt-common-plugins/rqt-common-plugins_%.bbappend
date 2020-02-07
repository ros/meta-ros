# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt-common-plugins] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on rqt-py-common->qtbase', '', d)}"
