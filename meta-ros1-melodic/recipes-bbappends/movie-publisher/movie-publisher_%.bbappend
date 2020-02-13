# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[movie-publisher] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'Depends on ffmpeg which requires commercial license', '', d)}"
