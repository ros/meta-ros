# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[teb-local-planner-tutorials] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on teb-local-planner->libg2o->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES', '', d)}"
