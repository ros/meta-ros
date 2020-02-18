# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[image-view] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['vc4graphics-without-opengl', 'x11'], 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES and gtk+ which depends on x11', '', d)}"
