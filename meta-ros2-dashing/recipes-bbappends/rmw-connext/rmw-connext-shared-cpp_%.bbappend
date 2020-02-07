# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rmw-connext-shared-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds which is not available', '', d)}"
