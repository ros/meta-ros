# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[tts] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['gst-python', 'vc4graphics-without-opengl'], 'gst-python: requires gstreamer1.0-python which requires gobject-introspection-data in DISTRO_FEATURES; vc4graphics-without-opengl: depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', '', d)}"
