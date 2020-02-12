# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[lauv-control] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, lauv-description which is not available', '', d)}"
