# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[libqt-svg-rosdev] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires qtsvg which requires meta-qt5 to be included', '', d)}"
