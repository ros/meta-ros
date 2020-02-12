# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rotors-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, rotors-gazebo-plugins which is not available', '', d)}"
