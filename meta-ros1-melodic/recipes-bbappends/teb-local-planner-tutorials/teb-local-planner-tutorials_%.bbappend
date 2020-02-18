# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[teb-local-planner-tutorials] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on teb-local-planner->libg2o->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and stage-ros->stage->(fltk,gtk+) which depends on x11', '', d)}"
