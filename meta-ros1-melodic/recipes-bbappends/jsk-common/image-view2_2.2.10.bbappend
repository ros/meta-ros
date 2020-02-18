# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[image-view2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', 'Depends on image-view->gtk+ which depends on x11', '', d)}"
