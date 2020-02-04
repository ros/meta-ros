# Copyright (c) 2020 LG Electronics, Inc.

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
ROS_BUILD_DEPENDS_remove = "rosidl-default-generators"

DEPENDS += "jsoncpp"
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-jsoncpp.patch"
