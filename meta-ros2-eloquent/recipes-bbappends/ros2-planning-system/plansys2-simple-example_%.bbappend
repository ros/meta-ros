# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[plansys2-simple-example] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coin-or', 'coin-or: Depends on plansys2-executor->popf->libcbc for which we do not have recipes yet', '', d)}"
