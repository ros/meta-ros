# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rexrov2-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, rexrov2-control, rexrov2-description which is not available', '', d)}"
