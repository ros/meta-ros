# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rc-visard] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on rc-roi-manager-gui->wxwidgets->freeglut which is not available because of missing opengl in DISTRO_FEATURES and rc-roi-manager-gui->wxwidgets which depends on x11', '', d)}"
