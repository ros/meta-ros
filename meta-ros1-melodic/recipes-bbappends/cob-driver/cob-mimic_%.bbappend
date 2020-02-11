# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-mimic] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'multimedia', 'Requires vlc which requires meta-multimedia to be included', '', d)}"
