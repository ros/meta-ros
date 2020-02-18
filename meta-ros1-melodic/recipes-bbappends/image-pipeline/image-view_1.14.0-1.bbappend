# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[image-view] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', 'Depends on gtk+ which depends on x11', '', d)}"
