# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[mir-navigation] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, mir-driver which is not available', '', d)}"
