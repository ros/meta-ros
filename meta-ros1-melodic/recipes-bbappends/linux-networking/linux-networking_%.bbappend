# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[linux-networking] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires asmach-tutorials which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included', 'depends on multi-interface-roam which depends on unavailable python-twisted-core', d)}"
