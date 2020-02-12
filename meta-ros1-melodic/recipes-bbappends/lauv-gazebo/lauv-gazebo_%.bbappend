# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[lauv-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, lauv-description which is not available', '', d)}"
