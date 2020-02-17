# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[prbt-grippers] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires prbt-pg70-support which depends on prbt-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', 'rdepends on prbt-pg70-support which depends on prbt-support which depends on canopen-motor-node which depends on unavailable UNRESOLVED-muparser', d)}"
