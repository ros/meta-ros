# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    fmilibrary \
"

# backport equivalent of following changes:
# foxy: https://github.com/ros/rosdistro/commit/d6f5a0ca09f6d15c4e1ae4beb85b25447355c120
# dashing: https://github.com/ros/rosdistro/commit/2617ae2b86d9eacee6f7b6a66472255047da87ba
SRC_URI = "git://github.com/ros2-gbp/fmilibrary_vendor-release;${ROS_BRANCH};protocol=https"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-just-depend-on-system-fmilibrary-with.patch"
