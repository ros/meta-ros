# Copyright (c) 2023 Wind River Systems, Inc.

# bounding_box_2d.cpp:15:10: fatal error: QPainter: No such file or directory
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
