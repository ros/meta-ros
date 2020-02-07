# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rosidl-typesupport-connext-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
PNBLACKLIST[rosidl-typesupport-connext-cpp-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
