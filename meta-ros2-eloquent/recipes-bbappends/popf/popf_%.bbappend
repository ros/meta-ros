# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[popf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coin-or', 'coin-or: depends on libcbc for which we do not have recipes yet', '', d)}"
