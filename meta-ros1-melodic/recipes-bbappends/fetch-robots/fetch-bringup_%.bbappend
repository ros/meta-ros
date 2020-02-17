# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[fetch-bringup] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyassimp'], 'Requires fetch-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included anddepends on fetch-moveit-config which rdepends on moveit-python which depends on unavailable UNRESOLVED-python-pyassimp', 'depends on openni2-launch which depends on openni2-camera which depends on unavailable UNRESOLVED-libopenni2-dev', d)}"
