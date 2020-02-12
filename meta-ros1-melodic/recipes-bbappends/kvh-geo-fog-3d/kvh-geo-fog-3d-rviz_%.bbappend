# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[kvh-geo-fog-3d-rviz] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires qtbase, qtdeclarative, qtmultimedia, qtsvg which requires meta-qt5 to be included', '', d)}"
