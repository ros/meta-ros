# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[jackal-desktop] ?= "${@ 'Requires jackal-viz which depends on rviz which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
