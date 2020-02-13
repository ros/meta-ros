# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[web-video-server] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'Depends on ffmpeg which requires commercial license', '', d)}"

PNBLACKLIST[web-video-server] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', '', d)}"
