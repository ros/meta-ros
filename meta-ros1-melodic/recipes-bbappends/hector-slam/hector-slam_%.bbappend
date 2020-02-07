# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[hector-slam] ?= "${@ 'Requires libqt4-dev which requires meta-qt4 to be included' if 'qt4-layer' not in BBFILE_COLLECTIONS.split() else '' }"
