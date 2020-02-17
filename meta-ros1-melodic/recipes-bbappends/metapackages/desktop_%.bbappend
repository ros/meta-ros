# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[desktop] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires ros-tutorials which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included and depends on viz which depends on rqt-robot-plugins which depends on rqt-pose-view which depends on unavailable UNRESOLVED-python-opengl, rqt-common-plugins which depend on rqt-bag-plugins which depends on unavailable UNRESOLVED-python-cairo', '', d)}"
