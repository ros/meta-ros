# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[mrpt-bridge] ?= "${@ 'Requires qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"

# Depends on ffmpeg with this restriction:
LICENSE_FLAGS = "commercial"
