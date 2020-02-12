# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-grasp-generation] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, cob-description which is not available', '', d)}"
