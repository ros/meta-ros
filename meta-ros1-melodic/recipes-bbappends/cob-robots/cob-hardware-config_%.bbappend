# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-hardware-config] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, cob-description, raw-description which is not available', '', d)}"
