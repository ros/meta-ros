# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[linux-networking] ?= "${@ 'Requires asmach-tutorials which depends on turtlesim which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
