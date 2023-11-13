# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# Instead of fetching
# https://github.com/modelon-community/fmi-library.git tag 2.1 with git
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = "git://github.com/boschresearch/fmi_adapter-release;${ROS_BRANCH};protocol=https;name=fmi-library-release"
SRCREV_fmi-library-release = "ebabc0691f1083e87d45e2199032550cc6a6646a"
SRC_URI += "file://0001-CMakeLists.txt-fetch-fmi-library-with-bitbake-fetche.patch \
    git://github.com/modelon-community/fmi-library.git;protocol=https;name=fmi-library;destsuffix=git/fmi-library-upstream;branch=master \
"
SRCREV_fmi-library-upstream = "d5ce0b923dd42fbc59b61edb17e837cd148e9501"
SRCREV_FORMAT = "fmi-library-release_fmi-library-upstream"
