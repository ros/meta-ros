# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[mrpt-slam] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'ffmpeg'], 'Requires mrpt-ekf-slam-2d, ... which depends on mrpt-bridge which depends on qtbase which requires meta-qt5 to be included and depends on ffmpeg which requires commercial license', '', d)}"
