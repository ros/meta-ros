# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[navigation-stage] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on stage-ros->stage->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES', '', d)}"
