# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[drone-wrapper] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, turtlebot3-gazebo which is not available', '', d)}"
