# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[abb] ?= "${@ 'Requires abb-irb6640-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
