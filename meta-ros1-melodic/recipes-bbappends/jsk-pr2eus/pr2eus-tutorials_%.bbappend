# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[pr2eus-tutorials] ?= "${@ 'Requires jsk-pcl-ros which depends on jsk-recognition-utils which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
