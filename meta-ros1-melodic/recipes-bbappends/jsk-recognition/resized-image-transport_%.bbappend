# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[resized-image-transport] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-ugly', 'Depends on jsk-topic-tools->sound-play which depends on gstreamer1.0-plugins-ugly which requires commercial license', '', d)}"
