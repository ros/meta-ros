# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[industrial-core] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on industrial-trajectory-filters->moveit-ros-planning->moveit-ros-perception->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and industrial-trajectory-filters->moveit-ros-planning->moveit-ros-perception->freeglut which requires x11', '', d)}"
