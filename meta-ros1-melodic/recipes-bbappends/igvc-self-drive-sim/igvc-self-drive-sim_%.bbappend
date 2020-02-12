# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[igvc-self-drive-sim] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, igvc-self-drive-gazebo which is not available', '', d)}"
