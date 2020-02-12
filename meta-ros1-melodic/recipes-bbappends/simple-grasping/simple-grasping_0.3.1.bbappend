# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[simple-grasping] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires libvtk-qt which is not available', '', d)}"
