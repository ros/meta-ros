# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/humanoid-path-planner/hpp-fcl.git tag v1.0.1 with git
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-hpp-fcl-with-bitbake-fetcher.patch \
    git://github.com/humanoid-path-planner/hpp-fcl.git;protocol=https;name=hpp-fcl-upstream;destsuffix=git/hpp-fcl-upstream;branch=master \
    git://github.com/jrl-umi3218/jrl-cmakemodules.git;protocol=https;name=hpp-fcl-cmake;destsuffix=git/hpp-fcl-upstream/cmake;branch=master \
"
SRCREV_hpp-fcl-upstream = "8d8fd44e39401ee03fbda7ae4e2e9ce5e9a88fff"
SRCREV_hpp-fcl-cmake = "ecaf20c28c8ce33de312fbd812f88037cf995b73"
