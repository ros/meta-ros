# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[openni2-launch] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', 'depends on openni2-camera which depends on unavailable UNRESOLVED-libopenni2-dev', d)}"
