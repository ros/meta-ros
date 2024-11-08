# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Upgrade-from-tinyxml-to-tinyxml2.patch"

# Replace tinyXML with tinyXML2
ROS_BUILD_DEPENDS:remove = "tinyxml-vendor libtinyxml"
ROS_EXEC_DEPENDS:remove = "tinyxml-vendor libtinyxml"

ROS_BUILD_DEPENDS += "tinyxml2-vendor libtinyxml2"
ROS_EXEC_DEPENDS += "tinyxml2-vendor libtinyxml2"
