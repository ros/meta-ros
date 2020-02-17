# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-pose-view] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires python-qt-binding which requires meta-qt5 to be included and depends on unavailable UNRESOLVED-python-opengl', '', d)}"
