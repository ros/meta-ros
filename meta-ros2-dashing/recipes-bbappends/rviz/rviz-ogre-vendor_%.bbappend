# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rviz-ogre-vendor] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'opengl: depends on mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES; x11: depends on libx11,libxrandr,libxaw which require x11 in DISTRO_FEATURES', '', d)}"
