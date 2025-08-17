DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=988919d688133096537549f9afebf425"
SRCNAME = "rosdistro"

inherit setuptools3

ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rosdistro;${ROS_BRANCH};protocol=https"
SRCREV = "9c909bfb7f34e13e8229f1742b6493b228a3cfa9"

RDEPENDS:${PN} += "python3-pyyaml"

BBCLASSEXTEND = "native nativesdk"

