# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[gl-dependency] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires python-qt5-bindings-gl which requires meta-qt5 to be included', '', d)}"
