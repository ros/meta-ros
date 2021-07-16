# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    fmilibrary \
"

# branches were recreated, the SRCREV exists, but isn't included in any branch
ROS_BRANCH = "nobranch=1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-just-depend-on-system-fmilibrary-with.patch"
