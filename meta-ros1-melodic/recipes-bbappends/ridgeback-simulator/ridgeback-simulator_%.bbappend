# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[ridgeback-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, ridgeback-gazebo which is not available', '', d)}"
