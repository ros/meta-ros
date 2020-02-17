# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[moveit-commander] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'pyassimp'], 'Depends on moveit-ros-planning-interface->moveit-ros-planning->moveit-ros-perception->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and depends on unavailable UNRESOLVED-python-pyassimp', '', d)}"
