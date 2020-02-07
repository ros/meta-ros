# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[cob-mimic] ?= "${@ 'Requires vlc which requires meta-multimedia to be included' if 'multimedia-layer' not in BBFILE_COLLECTIONS.split() else '' }"
