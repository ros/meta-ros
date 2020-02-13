# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[moveit-ros-planning-interface] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on moveit-ros-planning->moveit-ros-perception->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES', '', d)}"
