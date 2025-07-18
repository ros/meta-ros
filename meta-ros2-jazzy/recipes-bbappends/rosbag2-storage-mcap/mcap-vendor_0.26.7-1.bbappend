# Copyright (c) 2022 Wind River Systems, Inc.

# Use Bitbake to fetch https://github.com/foxglove/mcap.git
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI = " \
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/foxglove/mcap.git;protocol=https;name=mcap;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}/mcap;branch=main;lfs=0 \
    file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch \
    file://0001-cpp-add-missing-cstdint-include-gcc15-build-failure-.patch;patchdir=${S}/mcap \
"

SRCREV_release = "72c40f769b63c56c9f1a0856ce570da06e89aba6"
# releases/cpp/v1.1.0
SRCREV_mcap = "95b0c957463de7a56ec113f9b80c85f0d6a02d11"

SRCREV_FORMAT = "release_mcap"
#
# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

inherit pkgconfig
