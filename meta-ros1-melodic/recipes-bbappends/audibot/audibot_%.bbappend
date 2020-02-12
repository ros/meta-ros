# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[audibot] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, audibot-gazebo which is not available', '', d)}"
