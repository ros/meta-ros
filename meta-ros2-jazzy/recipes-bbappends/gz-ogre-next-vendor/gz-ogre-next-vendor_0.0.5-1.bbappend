# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-ogre-next.patch"

DEPENDS += "ogre-next"

ROS_EXEC_DEPENDS:remove = "libxaw"
ROS_EXEC_DEPENDS:append = "libxaw7"

# Replace mesa with virtual/mesa
ROS_BUILD_DEPENDS:remove = "mesa"
ROS_BUILD_DEPENDS:append = "virtual/mesa"
ROS_EXPORT_DEPENDS:remove = "mesa"
ROS_EXPORT_DEPENDS:append = "virtual/mesa"
