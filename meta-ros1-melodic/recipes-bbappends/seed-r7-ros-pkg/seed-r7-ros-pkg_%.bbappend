# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[seed-r7-ros-pkg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires seed-r7-moveit-config which depends on moveit-ros-visualization which depends on qtbase which requires meta-qt5 to be included', 'depends on seed-r7-samples which depends on smach-viewer which depends on wxpython which does not build: ld: cannot find -lwx_gtk3u_xrc-3.0', d)}"
