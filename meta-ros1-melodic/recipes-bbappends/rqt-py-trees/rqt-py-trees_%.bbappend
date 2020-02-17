# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-py-trees] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python-deps'], 'Requires qt-dotgraph which requires meta-qt5 to be included and depends on unavailable UNRESOLVED-python-termcolor, UNRESOLVED-python-pygraphviz', '', d)}"
