# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros2/Mimick.git revision 99a35f3d2067708931945c64ac9caee80a0ef50e
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-only-specified-mimick-files-n.patch \
    file://0002-CMakeLists.txt-fetch-mimick-with-bitbake-fetcher.patch \
    git://github.com/ros2/Mimick.git;protocol=https;name=mimick;branch=ros2;destsuffix=git/mimick-upstream \
"
SRCREV_mimick = "99a35f3d2067708931945c64ac9caee80a0ef50e"

# mimick-vendor/0.2.2-1-r0/recipe-sysroot/usr/include/features.h:397:4: error: #warning _FORTIFY_SOURCE requires compiling with optimization (-O) [-Werror=cpp]
lcl_maybe_fortify = ""
