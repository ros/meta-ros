# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-moveit-config] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', 'rdepends on moveit-python which depends on unavailable UNRESOLVED-python-pyassimp', d)}"
