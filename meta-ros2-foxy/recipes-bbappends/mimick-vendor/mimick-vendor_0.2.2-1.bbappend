# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros2/Mimick.git revision feb30f7520d80f99344978901a4c8496e698004c
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-only-specified-mimick-files-n.patch \
    file://0002-CMakeLists.txt-fetch-mimick-with-bitbake-fetcher.patch \
    git://github.com/ros2/Mimick.git;protocol=https;name=mimick;branch=ros2;destsuffix=git/mimick-upstream \
"
SRCREV_mimick = "feb30f7520d80f99344978901a4c8496e698004c"
