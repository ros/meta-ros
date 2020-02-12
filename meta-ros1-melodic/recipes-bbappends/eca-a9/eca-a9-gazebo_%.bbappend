# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[eca-a9-gazebo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, eca-a9-description which is not available', '', d)}"
