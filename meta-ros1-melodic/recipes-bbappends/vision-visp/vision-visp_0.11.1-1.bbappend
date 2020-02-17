# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[vision-visp] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['vc4graphics-without-opengl', 'ogre'], 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES and depends on visp-bridge, visp-auto-tracker, visp-hand2eye-calibration, visp-tracker, visp-camera-calibration which depend on ogre which is not available', '', d)}"
