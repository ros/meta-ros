# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[connext-cmake-module] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds which is not available', '', d)}"
PNBLACKLIST[connext-cmake-module-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
