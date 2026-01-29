# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-ogre-next.patch"

# Replace dependencies to use ogre-next instead of building it
ROS_BUILD_DEPENDS = "gz-cmake-vendor ogre-next"
ROS_EXEC_DEPENDS = ""
ROS_EXPORT_DEPENDS = ""
