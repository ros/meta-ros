# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[neonavigation] ?= "${@ 'Requires neonavigation-launch which depends on trajectory-tracker-rviz-plugins which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
