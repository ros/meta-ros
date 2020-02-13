# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[gundam-rx78-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, gazebo-ros, gundam-rx78-control, gazebo-plugins, gazebo-ros-control which is not available', '', d)}"
