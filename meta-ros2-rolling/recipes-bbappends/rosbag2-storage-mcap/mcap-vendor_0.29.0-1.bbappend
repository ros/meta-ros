# Copyright (c) 2022-2024 Wind River Systems, Inc.

# Use Bitbake to fetch https://github.com/foxglove/mcap.git
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI = " \
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/foxglove/mcap.git;protocol=https;name=mcap;destsuffix=git/mcap;branch=main;lfs=0 \
    file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch\
"

SRCREV_release = "a455af16b8746fe05532b774fe689ef5e9a11117"
# releases/cpp/v1.1.0
SRCREV_mcap = "95b0c957463de7a56ec113f9b80c85f0d6a02d11"

SRCREV_FORMAT = "release_mcap"

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

inherit pkgconfig
