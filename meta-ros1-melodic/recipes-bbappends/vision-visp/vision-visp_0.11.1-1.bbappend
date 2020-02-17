# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[vision-visp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ogre', 'Depends on visp-bridge, visp-auto-tracker, visp-hand2eye-calibration, visp-tracker, visp-camera-calibration which depend on ogre which is not available', '', d)}"
