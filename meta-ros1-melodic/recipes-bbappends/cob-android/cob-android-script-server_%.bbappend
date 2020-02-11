# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-android-script-server] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', 'Requires cob-script-server which depends on cob-mimic, cob-sound which depends on vlc which requires meta-multimedia to be included', '', d)}"
