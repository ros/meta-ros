# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[octovis] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', 'qt4: depends on qt4 packages UNRESOLVED-libqt4-opengl-dev, UNRESOLVED-libqglviewer-qt4-dev, UNRESOLVED-libqt4-dev, UNRESOLVED-libqt4-opengl, UNRESOLVED-libqtgui4', '', d)}"
