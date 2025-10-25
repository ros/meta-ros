# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros2/Mimick.git revision f171450b5ebaa3d2538c762a059dfc6ab7a01039
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = "git://github.com/ros2/mimick_vendor.git;${ROS_BRANCH};protocol=https \
    file://0002-CMakeLists.txt-fetch-mimick-with-bitbake-fetcher.patch \
    git://github.com/ros2/Mimick.git;protocol=https;name=mimick;branch=ros2;destsuffix=git/mimick-upstream \
"
SRCREV_release = "${SRCREV}"
SRCREV_mimick = "4dbd495e9f3d87a83c3201ef9d851e85f7133db7"
SRCREV_FORMAT = "release_mimick"

# mimick-vendor/0.2.2-1-r0/recipe-sysroot/usr/include/features.h:397:4: error: #warning _FORTIFY_SOURCE requires compiling with optimization (-O) [-Werror=cpp]
lcl_maybe_fortify = ""
