# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-sound] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['multimedia', 'vlc'], 'Requires vlc which requires meta-multimedia to be included', '', d)}"
