# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[open-manipulator-with-tb3-simulations] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, open-manipulator-with-tb3-gazebo which is not available', '', d)}"
