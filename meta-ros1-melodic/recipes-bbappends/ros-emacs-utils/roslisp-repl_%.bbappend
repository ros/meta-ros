# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[roslisp-repl] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'depends on sbcl for which there is no OE recipe', '', d)}"
