# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[cob-moveit-bringup] = "${@ 'Requires moveit-ros-visualization which depends on moveit-setup-assistant which depends on qtbase which requires meta-qt5 to be included' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"
