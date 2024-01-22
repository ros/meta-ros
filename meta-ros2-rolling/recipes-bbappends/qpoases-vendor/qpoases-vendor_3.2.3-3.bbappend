# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# SVN_REPOSITORY https://projects.coin-or.org/svn/qpOASES/stable/3.2
# during do_compile fetch it with bitbake's git fetcher from github, because
# https://projects.coin-or.org/qpOASES only shows:
# This project has moved t https://github.com/coin-or/qpOASES
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/ros2-gbp/qpoases_vendor-release;name=release;${ROS_BRANCH};protocol=https \
    file://0001-CMakeLists.txt-fetch-qpOASES-with-bitbake-fetcher.patch \
    git://github.com/coin-or/qpOASES;protocol=https;branch=stable/3.2;name=qpOASES-upstream;destsuffix=git/qpOASES-upstream \
"
SRCREV_release = "9cbeef616ed2d3b92733f9c38bfc33d56075dfe2"
SRCREV_qpOASES-upstream = "4799956d98cb9a5ca32e818c6ef79b69103392d8"
SRCREV_FORMAT = "release_qpOASES-upstream"
