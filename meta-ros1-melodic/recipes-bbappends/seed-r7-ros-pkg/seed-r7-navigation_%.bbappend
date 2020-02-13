# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[seed-r7-navigation] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on teb-local-planner->stage->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES', '', d)}"
