# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "A python interface to Graphviz"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f5ce36373e1542c5b82d521315da8cc2"
SRCNAME = "pydot"

SRCREV = "979b0b7685c911fd8ef05feec1d3fe8c62e3247d"
ROS_BRANCH ?= "branch=main"
SRC_URI = "git://github.com/pydot/pydot;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
