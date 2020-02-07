# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[h264-video-encoder] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: Depends on h264-encoder-core->ffmpeg which requires commercial license', '', d)}"
