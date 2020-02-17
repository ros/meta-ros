# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[visp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', 'Depends on ogre which is not available', '', d)}"
