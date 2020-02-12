# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[eus-assimp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on blacklisted euslisp, roseus', '', d)}"
