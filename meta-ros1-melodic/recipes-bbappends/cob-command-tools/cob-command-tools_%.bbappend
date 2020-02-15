# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-command-tools] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'multimedia'], 'Requires cob-dashboard which depends on rqt-gui which depends on qt-gui which depends on qtbase which requires meta-qt5 to be included and depends on cob-mimic, cob-sound which depends on vlc which requires meta-multimedia to be included', '', d)}"
