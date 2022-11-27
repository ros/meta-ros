# Copyright (c) 2020 LG Electronics, Inc.

# uncrustify appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "uncrustify"
ROS_EXEC_DEPENDS:remove = "uncrustify"

# Instead of fetching
# https://github.com/uncrustify/uncrustify/archive/45b836cff040594994d364ad6fd3f04adc890a26.tar.gz
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-uncrustify-with-bitbake-fetcher.patch \
    git://github.com/uncrustify/uncrustify.git;protocol=https;name=uncrustify;destsuffix=git/uncrustify-upstream;branch=master \
    https://raw.githubusercontent.com/ros2-gbp/uncrustify_vendor-release/e2bddd9df7abe1099ea9788e5b3811adabe9481e/install-patch.diff;name=patch;patchdir=uncrustify-upstream \
"
# Using uncrustify-0.72.0 tag
SRCREV_uncrustify = "1d3d8fa5e81bece0fac4b81316b0844f7cc35926"

SRC_URI[patch.md5sum] = "43fb113fc0ce0e8a70df7c3d3e15db2c"
SRC_URI[patch.sha256sum] = "3625786526f2d03252d94cd9b2ae4620d93f586938f28dde28d3094c36c2aa48"
