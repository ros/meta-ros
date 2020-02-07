# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-helper-tools] ?= "${@ 'Requires cob-script-server which depends on cob-mimic, cob-sound which depends on vlc which requires meta-multimedia to be included' if 'multimedia-layer' not in BBFILE_COLLECTIONS.split() else '' }"
