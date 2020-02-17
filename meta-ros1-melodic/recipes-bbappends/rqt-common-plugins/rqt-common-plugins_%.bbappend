# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-common-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires rqt-py-common which requires meta-qt5 to be included and depends on rqt-bag-plugins which depends on unavailable UNRESOLVED-python-cairo', '', d)}"
