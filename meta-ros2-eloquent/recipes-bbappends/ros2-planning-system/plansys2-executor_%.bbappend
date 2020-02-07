# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[plansys2-executor] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coin-or', 'coin-or: depends on popf->libcbc for which we do not have recipes yet', '', d)}"
