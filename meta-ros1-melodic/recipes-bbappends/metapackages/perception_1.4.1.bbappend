# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[perception] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', 'Depends on image-pipeline->image-view->gtk+ which depends on x11', '', d)}"
