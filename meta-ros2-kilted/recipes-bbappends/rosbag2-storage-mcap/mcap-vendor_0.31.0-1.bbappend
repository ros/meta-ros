# Copyright (c) 2022-2024 Wind River Systems, Inc.

# Use Bitbake to fetch https://github.com/foxglove/mcap.git
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI = " \
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/foxglove/mcap.git;protocol=https;name=mcap;destsuffix=git/mcap;branch=main;lfs=0 \
    file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch\
"

SRCREV_release = "${SRCREV}"
# releases/cpp/v1.4.0
SRCREV_mcap = "9e7838c3ea51336d84141a80e2ffb15c589d2f54"

SRCREV_FORMAT = "release_mcap"

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

inherit pkgconfig
