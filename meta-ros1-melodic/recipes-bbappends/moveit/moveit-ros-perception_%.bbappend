# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[moveit-ros-perception] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and freeglut which requires x11', '', d)}"
