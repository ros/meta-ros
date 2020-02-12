# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[roseus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on blacklisted geneus, euslisp', '', d)}"
