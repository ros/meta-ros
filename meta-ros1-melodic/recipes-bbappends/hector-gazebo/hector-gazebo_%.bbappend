# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[hector-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, hector-gazebo-worlds, hector-gazebo-plugins, hector-gazebo-thermal-camera which is not available', '', d)}"
