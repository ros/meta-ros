# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# SVN_REPOSITORY https://projects.coin-or.org/svn/qpOASES/stable/3.2
# during do_compile fetch it with bitbake's git fetcher from github, because
# https://projects.coin-or.org/qpOASES only shows:
# This project has moved t https://github.com/coin-or/qpOASES
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = "git://github.com/autoware-ai/qpoases_vendor-release;${ROS_BRANCH};protocol=https;name=qpOASES-release"
SRCREV_qpOASES-release = "37962324bdc1c603d4889b77b2c7389e8d91a01b"
SRC_URI += "file://0001-CMakeLists.txt-fetch-qpOASES-with-bitbake-fetcher.patch \
    git://github.com/coin-or/qpOASES;protocol=https;branch=stable/3.2;name=qpOASES-upstream;destsuffix=git/qpOASES-upstream \
"
SRCREV_qpOASES-upstream = "4799956d98cb9a5ca32e818c6ef79b69103392d8"
SRCREV_FORMAT = "qpOASES-release_qpOASES-upstream"
