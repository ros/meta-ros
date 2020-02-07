# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[tts] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-python', 'gst-python: requires gstreamer1.0-python which requires gobject-introspection-data in DISTRO_FEATURES', '', d)}"
