# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-boost-system.patch \
            file://add-bullet-dependency.patch"

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

do_install:append() {
    # Fix for QA warning [buildpaths]
    # Remove ${RECIPE_SYSROOT}/usr/include added by the Boost components
    sed -i -e "s#${RECIPE_SYSROOT}${includedir};##g" ${D}${ros_datadir}/moveit_ros_visualization/cmake/moveit_ros_visualizationTargetsExport.cmake
}

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
