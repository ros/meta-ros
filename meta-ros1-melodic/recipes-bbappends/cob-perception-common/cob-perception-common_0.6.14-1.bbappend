# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-perception-common] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', '', d)}"
