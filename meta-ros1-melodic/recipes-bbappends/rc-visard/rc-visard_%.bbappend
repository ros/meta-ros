# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rc-visard] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on rc-roi-manager-gui->wxwidgets->freeglut which is not available because of missing opengl in DISTRO_FEATURES', '', d)}"
