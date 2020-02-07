# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[ament-cmake-clang-tidy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', 'clang: depends on ament-clang-tidy-native->clang-tidy', '', d)}"
