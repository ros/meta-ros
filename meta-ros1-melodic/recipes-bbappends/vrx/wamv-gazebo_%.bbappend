# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[wamv-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, hector-gazebo-plugins, gazebo-plugins, velodyne-gazebo-plugins, usv-gazebo-plugins which is not available', '', d)}"
