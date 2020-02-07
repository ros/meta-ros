# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rmw-opensplice-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'opensplice: depends on libopensplice69 which is not available', '', d)}"
