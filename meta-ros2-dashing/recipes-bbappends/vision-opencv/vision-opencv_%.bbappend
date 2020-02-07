# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[vision-opencv] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', 'vc4graphics-without-opengl: depends on cv-bridge->opencv->gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', '', d)}"
