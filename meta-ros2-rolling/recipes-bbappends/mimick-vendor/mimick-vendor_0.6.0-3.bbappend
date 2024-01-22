# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros2/Mimick.git revision f171450b5ebaa3d2538c762a059dfc6ab7a01039
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = "git://github.com/ros2-gbp/mimick_vendor-release;name=release;${ROS_BRANCH};protocol=https \
    file://0001-CMakeLists.txt-install-only-specified-mimick-files-n.patch \
    file://0002-CMakeLists.txt-fetch-mimick-with-bitbake-fetcher.patch \
    git://github.com/ros2/Mimick.git;protocol=https;name=mimick;branch=ros2;destsuffix=git/mimick-upstream \
"
SRCREV_release = "c1a4219fa4355899238341e35317f09f9e258ce3"
SRCREV_mimick = "f171450b5ebaa3d2538c762a059dfc6ab7a01039"
SRCREV_FORMAT = "release_mimick"

# mimick-vendor/0.2.2-1-r0/recipe-sysroot/usr/include/features.h:397:4: error: #warning _FORTIFY_SOURCE requires compiling with optimization (-O) [-Werror=cpp]
lcl_maybe_fortify = ""
