# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

require orocos-kdl.inc

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d94c5c8f30151b2fe7d07ba53ed6444b"

# orocos-kdl appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "python3-pykdl"
ROS_EXEC_DEPENDS:remove = "python3-pykdl"

S = "${WORKDIR}/git/orocos-kdl/python_orocos_kdl"

SRC_URI[patch.md5sum] = "0208162d10526b13e62a6cdef2dadc84"
SRC_URI[patch.sha256sum] = "bed98c6c2a0261488d522b80fc792fd3ad817b01d7344342f28a470bd140c481"

FILES:${PN}-dev += "${datadir}/orocos_kdl/cmake/*.cmake"

inherit ros_insane_dev_so
