# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[jackal-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, jackal-gazebo which is not available', '', d)}"
