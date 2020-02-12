# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[desistek-saga-control] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, desistek-saga-description which is not available', '', d)}"
