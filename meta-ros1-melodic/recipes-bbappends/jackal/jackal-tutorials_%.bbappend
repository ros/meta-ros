# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[jackal-tutorials] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on blacklisted rosdoc-lite', '', d)}"
