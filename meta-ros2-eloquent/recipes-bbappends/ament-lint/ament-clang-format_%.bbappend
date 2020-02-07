# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[ament-clang-format] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', 'clang: depends on clang-format', '', d)}"
PNBLACKLIST[ament-clang-format-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', 'clang: depends on clang-format', '', d)}"
