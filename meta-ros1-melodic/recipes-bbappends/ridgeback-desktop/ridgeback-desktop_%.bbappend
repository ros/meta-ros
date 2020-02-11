# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[ridgeback-desktop] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires ridgeback-viz which depends on rviz which requires meta-qt5 to be included', '', d)}"
