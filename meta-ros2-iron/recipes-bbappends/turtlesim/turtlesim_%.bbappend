# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (C) 2023 Advanced Micro Devices, Inc.  All rights reserved.

LICENSE = "BSD-3-Clause"

# Make this conditional on meta-qt5, because otherwise builds without
# meta-qt5 fail to parse, before turtlesim is SKIP_RECIPEed based
# on qt5 in ROS_WORLD_SKIP_GROUPS
# ERROR: ParseError at meta-ros/meta-ros2-dashing/recipes-bbappends/turtlesim/turtlesim_%.bbappend:3: Could not inherit file classes/cmake_qt5.bbclass
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

# Keep in mind that this needs widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG:remove = "widgets"

DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"
