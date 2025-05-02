# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://split-the-generator-expression-for-each-library.patch"

ROS_BUILD_DEPENDS += "\
    rosidl-generator-cpp-native \
"

ROS_EXEC_DEPENDS:remove = "rmw-zenoh-cpp"
ROS_EXEC_DEPENDS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', 'rmw-zenoh-cpp', '', d)}"
