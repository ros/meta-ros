# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[h264-encoder-core] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'Depends on ffmpeg which requires commercial license', '', d)}"
