# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[cob-teleop] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', 'Requires cob-sound which depends on vlc which requires meta-multimedia to be included', '', d)}"
