# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/humanoid-path-planner/hpp-fcl.git tag v1.0.1 with git
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-hpp-fcl-with-bitbake-fetcher.patch \
    git://github.com/humanoid-path-planner/hpp-fcl.git;protocol=https;name=hpp-fcl-upstream;destsuffix=git/hpp-fcl-upstream \
"
SRCREV_hpp-fcl-upstream = "8d8fd44e39401ee03fbda7ae4e2e9ce5e9a88fff"
