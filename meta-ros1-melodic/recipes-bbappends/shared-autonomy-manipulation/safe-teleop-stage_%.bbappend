# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[safe-teleop-stage] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on stage->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and stage->(fltk,gtk+) which depends on x11', '', d)}"
