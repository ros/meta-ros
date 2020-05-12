# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/flexible-collision-library/fcl/archive/v0.6.0.zip with curl
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-fcl-with-bitbake-fetcher.patch \
    git://github.com/flexible-collision-library/fcl.git;protocol=https;name=fcl-upstream;destsuffix=git/fcl-upstream \
    file://0001-CMakeLists.txt-don-t-use-SYSTEM-for-ccd-eigen3-and-o.patch;patchdir=fcl-upstream \
"
SRCREV_fcl-upstream = "a13c681e41eb8180cba7d4fd32637511f588cb82"
