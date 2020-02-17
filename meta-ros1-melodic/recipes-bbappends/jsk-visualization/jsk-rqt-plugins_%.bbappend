# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[jsk-rqt-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires rqt-image-view which depends on qtbase which requires meta-qt5 to be included and depends on unavailable UNRESOLVED-python-urlgrabber, UNRESOLVED-python-sklearn', '', d)}"

