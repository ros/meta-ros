# Copyright (c) 2022-2024 Wind River Systems, Inc.

# Use Bitbake to fetch https://github.com/foxglove/mcap.git
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI = "\
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/foxglove/mcap.git;protocol=https;name=mcap;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}/mcap;branch=main;lfs=0 \
    file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch \
"

SRCREV_release = "${SRCREV}"
# releases/cpp/v2.1.3
SRCREV_mcap = "1420296ffcfdcde4b6894c0c1aba0ad083f93dde"

SRCREV_FORMAT = "release_mcap"

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"
ROS_BUILD_DEPENDS:append = "zstd"

inherit pkgconfig
