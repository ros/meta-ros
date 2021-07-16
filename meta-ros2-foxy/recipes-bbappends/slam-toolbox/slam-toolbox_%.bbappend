# Copyright (c) 2020 Intel Corp.

ROS_BUILD_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_BUILDTOOL_DEPENDS:append = " rosidl-default-generators-native rosidl-typesupport-fastrtps-cpp-native rosidl-typesupport-fastrtps-c-native"
ROS_EXPORT_DEPENDS:append = " ceres-solver"
ROS_EXEC_DEPENDS:append = " rosidl-typesupport-fastrtps-cpp rosidl-typesupport-fastrtps-c"
ROS_EXEC_DEPENDS:remove = "ceres-solver"

FILES:${PN}-dev += "${datadir}/karto_sdk ${datadir}/solver_plugins.xml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-build-issue.patch"
