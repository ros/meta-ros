# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[jsk-model-tools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on blacklisted eus-assimp', '', d)}"
