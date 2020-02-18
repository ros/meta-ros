# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[uwsim-bullet] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'x11'], 'Depends on freeglut which is not available because of missing opengl and libxext, freeglut which require x11 in DISTRO_FEATURES', '', d)}"
