# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cross-compile] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'docker', 'docker: depends on python3-docker which is available in meta-virtualization', '', d)}"
