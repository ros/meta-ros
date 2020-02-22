# Copyright (c) 2020 LG Electronics, Inc.

# Make this conditional on meta-qt5, because otherwise builds without
# meta-qt5 fail to parse, before turtlesim is PNBLACKLISTed based
# on qt5 in ROS_WORLD_SKIP_GROUPS
# ERROR: ParseError at meta-ros/meta-ros2-dashing/recipes-bbappends/turtlesim/turtlesim_%.bbappend:3: Could not inherit file classes/cmake_qt5.bbclass
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

# Keep in mind that this needs widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG_remove = "widgets"
