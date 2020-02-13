# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[trac-ik-lib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'trac-ik', 'Depends on libnlopt0 which is not available', '', d)}"
