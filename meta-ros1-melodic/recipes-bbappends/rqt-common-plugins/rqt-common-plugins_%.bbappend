# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-common-plugins] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires rqt-py-common which requires meta-qt5 to be included', '', d)}"
