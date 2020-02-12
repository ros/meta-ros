# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[husky-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, husky-gazebo which is not available', '', d)}"
