# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    fmilibrary \
"

# backport https://github.com/ros/rosdistro/commit/2617ae2b86d9eacee6f7b6a66472255047da87ba
SRC_URI = "git://github.com/ros2-gbp/fmilibrary_vendor-release;${ROS_BRANCH};protocol=https"
# branches were recreated, the SRCREV exists, but isn't included in any branch
ROS_BRANCH = "nobranch=1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-just-depend-on-system-fmilibrary-with.patch"
