# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-script-server] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['multimedia', 'vlc'], 'Requires cob-mimic, cob-sound which depends on vlc which requires meta-multimedia to be included', '', d)}"
