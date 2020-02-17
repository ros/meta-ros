# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[prbt-moveit-config] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', 'depends on prbt-hardware-support which depends on pilz-utils which depends on unavailable clang-tidy and depends on prbt-support which depends on canopen-motor-node which depends on unavailable UNRESOLVED-muparser', d)}"
