# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[tts] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', 'Depends on sound-play which depends on gstreamer1.0-plugins-ugly which requires commercial license', '', d)}"
