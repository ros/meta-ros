# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[pr2-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo which is not available', '', d)}"
