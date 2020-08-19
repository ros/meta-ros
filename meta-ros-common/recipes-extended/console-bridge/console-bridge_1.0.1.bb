DESCRIPTION = "console_bridge is a ROS-independent, pure CMake package that provides logging \
calls that mirror those found in rosconsole, but for applications that are not necessarily using \
ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "\
    file://include/console_bridge/console.h;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
    file://src/console.cpp;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
"

DEPENDS = "boost"

ROS_BPN = "console_bridge"
ROS_SPN = "${ROS_BPN}"
ROS_SP = "${ROS_BPN}-${PV}"

SRCREV = "0a6c16ed68750837c32ed1cedee9fca7d61d4364"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros/console_bridge;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit cmake

# For some reason, the cmake subdir is under ${libdir} instead of ${datadir} for this component.
FILES_${PN}-dev += "${libdir}/${ROS_BPN}/cmake"
