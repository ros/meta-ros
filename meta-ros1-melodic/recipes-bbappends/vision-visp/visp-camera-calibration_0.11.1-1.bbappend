# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[visp-camera-calibration] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', 'Depends on visp which depends on ogre which is not available', '', d)}"
