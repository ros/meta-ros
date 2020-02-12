# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[haros-catkin] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on blacklisted catkin-virtualenv', '', d)}"
