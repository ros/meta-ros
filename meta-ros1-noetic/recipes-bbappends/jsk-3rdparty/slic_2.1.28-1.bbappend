# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# Instead of fetching
# https://github.com/garaemon/SLIC-Superpixels 78d9a2ba7ae1d3fee8c2ec774a52536c5f08f07c with git
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = "git://github.com/tork-a/jsk_3rdparty-release;${ROS_BRANCH};protocol=https;name=slic-release"
SRCREV_release = "bfe98e942e4a3c2101285de35b4fcb87943c0633"

SRC_URI += "file://0001-CMakeLists.txt-fetch-slic-with-bitbake-fetcher.patch \
    git://github.com/garaemon/SLIC-Superpixels.git;protocol=https;name=slic-upstream;destsuffix=git/slic-upstream;branch=master \
    file://0001-CMakeLists.txt-add-very-simple-CMake-file.patch;patchdir=slic-upstream \
"
SRCREV_slic-upstream = "78d9a2ba7ae1d3fee8c2ec774a52536c5f08f07c"
SRCREV_FORMAT = "slic-release_slic-upstream"
