# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[uuv-world-ros-plugins] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, gazebo-rosdev which is not available', '', d)}"
