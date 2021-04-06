# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    fmilibrary \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=665599198b8a9e42fd087c8d041ec61f"

ROS_BRANCH = "branch=foxy"
SRC_URI = "git://github.com/boschresearch/fmilibrary_vendor;${ROS_BRANCH};protocol=https"
SRCREV = "7ad20fa47c86c522dfed7c9685555656bc718c68"

SRC_URI += "file://0001-CMakeLists.txt-just-depend-on-system-fmilibrary-with.patch"
