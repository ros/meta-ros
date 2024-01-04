# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    rviz-default-plugins \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# CMake Warning at moveit-ros-visualization/2.5.5-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at motion_planning_rviz_plugin/CMakeLists.txt:8 (qt5_wrap_ui):
#   Unknown CMake command "qt5_wrap_ui".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}

# QA Issue: non -dev/-dbg/nativesdk- package moveit-ros-visualization contains symlink .so
FILES:${PN}-dev += " \
    ${libdir}/libmoveit_motion_planning_rviz_plugin.so \
    ${libdir}/libmoveit_motion_planning_rviz_plugin_core.so \
    ${libdir}/libmoveit_planning_scene_rviz_plugin.so \
    ${libdir}/libmoveit_planning_scene_rviz_plugin_core.so \
    ${libdir}/libmoveit_robot_state_rviz_plugin.so \
    ${libdir}/libmoveit_robot_state_rviz_plugin_core.so \
    ${libdir}/libmoveit_rviz_plugin_render_tools.so \
    ${libdir}/libmoveit_trajectory_rviz_plugin.so \
    ${libdir}/libmoveit_trajectory_rviz_plugin_core.so \
"
