# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-ros] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires fetch-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', 'rdepends on fetch-moveit-config which rdepends on moveit-python which depends on unavailable UNRESOLVED-python-pyassimp', d)}"
