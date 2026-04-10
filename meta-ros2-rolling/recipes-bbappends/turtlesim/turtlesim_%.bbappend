# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (C) 2023 Advanced Micro Devices, Inc.  All rights reserved.

LICENSE = "BSD-3-Clause"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
#
# Make this conditional on meta-qt5, because otherwise builds without
# meta-qt5 fail to parse, before turtlesim is SKIP_RECIPEed based
# on qt5 in ROS_WORLD_SKIP_GROUPS
#
# ERROR: ParseError at meta-ros/meta-ros2-rolling/recipes-bbappends/turtlesim/turtlesim_%.bbappend:3: Could not inherit file classes/qt6-cmake.bbclass
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

# Keep in mind that this needs widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG:remove = "widgets"

DEPENDS += "\
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"
