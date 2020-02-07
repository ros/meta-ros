# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[grid-map-demos] ?= "${@ 'Requires grid-map-rviz-plugin which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
