# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[uwsim-bullet] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on freeglut which is not available because of missing opengl in DISTRO_FEATURES', '', d)}"
