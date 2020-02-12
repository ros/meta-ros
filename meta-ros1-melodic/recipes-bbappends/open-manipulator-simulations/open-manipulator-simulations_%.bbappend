# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[open-manipulator-simulations] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, open-manipulator-gazebo which is not available', '', d)}"
