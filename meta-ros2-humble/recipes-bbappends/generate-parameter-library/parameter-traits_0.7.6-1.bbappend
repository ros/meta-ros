# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-upstream-tl-expected.patch"

# tl-expected does not have a runtime package
ROS_EXEC_DEPENDS:remove = "tl-expected"
