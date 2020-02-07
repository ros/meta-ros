# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[launch-testing-ament-cmake] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch: depends on launch-testing-native->launch-native', '', d)}"
