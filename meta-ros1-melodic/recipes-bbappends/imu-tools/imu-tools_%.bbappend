# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[imu-tools] ?= "${@ 'Requires rviz-imu-plugin which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
