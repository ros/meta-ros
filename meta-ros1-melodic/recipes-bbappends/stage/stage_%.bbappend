# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[stage] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and fltk, gtk+ which depend on x11', '', d)}"
