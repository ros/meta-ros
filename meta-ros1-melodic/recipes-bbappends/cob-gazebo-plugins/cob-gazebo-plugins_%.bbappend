# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-gazebo-plugins] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, cob-gazebo-ros-control which is not available', '', d)}"
