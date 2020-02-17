# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-robot-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires rqt-rviz which depends on qtbase which requires meta-qt5 to be included and depends on rqt-pose-view which depends on unavailable UNRESOLVED-python-opengl', '', d)}"
