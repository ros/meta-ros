# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[igvc-self-drive-description] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, hector-gazebo-plugins which is not available', '', d)}"
