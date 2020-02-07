# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[ament-clang-tidy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', 'clang: depends on clang-tidy', '', d)}"
PNBLACKLIST[ament-clang-tidy-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', 'clang: depends on clang-tidy', '', d)}"
