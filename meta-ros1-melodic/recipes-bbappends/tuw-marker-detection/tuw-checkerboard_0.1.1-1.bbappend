# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[tuw-checkerboard] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', 'Depends on image-view->gtk+ which depends on x11', '', d)}"
