# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[warthog-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, warthog-gazebo which is not available', '', d)}"
