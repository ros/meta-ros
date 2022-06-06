# Copyright (c) 2021 Intel Corp.

ROS_BUILD_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_BUILDTOOL_DEPENDS:append = " rosidl-default-generators-native rosidl-typesupport-fastrtps-cpp-native rosidl-typesupport-fastrtps-c-native"
ROS_EXPORT_DEPENDS:append = " ceres-solver"
ROS_EXEC_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_EXEC_DEPENDS:remove = "ceres-solver"

FILES:${PN}-dev += "${datadir}/karto_sdk ${datadir}/solver_plugins.xml"
FILES:${PN}-dev += "${datadir}/rviz_plugins.xml"

inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-fix-build-issue.patch"
