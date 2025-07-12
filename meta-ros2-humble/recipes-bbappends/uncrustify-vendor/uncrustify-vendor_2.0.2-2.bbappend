# Copyright (c) 2020 LG Electronics, Inc.

# uncrustify appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "uncrustify"
ROS_EXEC_DEPENDS:remove = "uncrustify"

# Instead of fetching
# https://github.com/uncrustify/uncrustify/archive/45b836cff040594994d364ad6fd3f04adc890a26.tar.gz
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-uncrustify-with-bitbake-fetcher.patch \
    git://github.com/uncrustify/uncrustify.git;protocol=https;name=uncrustify;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}/uncrustify-upstream;branch=master \
    file://install-patch.diff;name=patch;patchdir=uncrustify-upstream \
"
# Using uncrustify-0.72.0 tag
SRCREV_uncrustify = "1d3d8fa5e81bece0fac4b81316b0844f7cc35926"
SRCREV_FORMAT += "_uncrustify"

SRC_URI[patch.sha256sum] = "3625786526f2d03252d94cd9b2ae4620d93f586938f28dde28d3094c36c2aa48"
