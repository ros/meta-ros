# Copyright (c) 2020 Intel Corp.

ROS_BUILD_DEPENDS_append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_BUILDTOOL_DEPENDS_append = " rosidl-default-generators-native rosidl-typesupport-fastrtps-cpp-native rosidl-typesupport-fastrtps-c-native"
ROS_EXPORT_DEPENDS_append = " ceres-solver"
ROS_EXEC_DEPENDS_append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_EXEC_DEPENDS_remove = "ceres-solver"

FILES_${PN}-dev += "${datadir}/karto_sdk ${datadir}/solver_plugins.xml"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-build-issue.patch"
