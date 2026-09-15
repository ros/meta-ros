# Copyright (c) 2026 Wind River Systems, Inc.

LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=4633480cdd27d7906aaf3ef4b72014b2"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-upstream-tl-expected.patch"

# tl-expected does not have a runtime package
ROS_EXEC_DEPENDS:remove = "tl-expected"
