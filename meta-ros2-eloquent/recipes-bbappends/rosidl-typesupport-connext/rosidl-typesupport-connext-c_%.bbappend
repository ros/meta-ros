# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rosidl-typesupport-connext-c] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on (rosidl-typesupport-connext-cpp-native,connext-cmake-module-native)->rti-connext-dds-native which is not available', '', d)}"
