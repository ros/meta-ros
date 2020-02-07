# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[webkit-dependency] ?= "${@ 'Requires python-qt5-bindings-webkit which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
