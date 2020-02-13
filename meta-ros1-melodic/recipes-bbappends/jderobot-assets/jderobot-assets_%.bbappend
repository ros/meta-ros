# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[jderobot-assets] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, gazebo-ros, turtlebot3-gazebo which is not available', '', d)}"
