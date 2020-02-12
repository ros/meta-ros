# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[mir-driver] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, mir-description which is not available', '', d)}"
