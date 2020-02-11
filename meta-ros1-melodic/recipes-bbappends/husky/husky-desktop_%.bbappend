# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[husky-desktop] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires husky-rviz which depends on rviz which requires meta-qt5 to be included', '', d)}"
