# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[pr2-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, pr2-gazebo, pr2-gazebo-plugins, pr2-controller-configuration-gazebo which is not available', '', d)}"
