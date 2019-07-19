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

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "12e9a6b876ef160fc4a705003790ede0"
SRC_URI[sha256sum] = "f44641bed7268d72354476c8c5ff936f0e600e4170e1ff7f61a4b6e1f3fc20ff"

S = "${WORKDIR}/${ROS_SP}"

inherit cmake

# For some reason, the cmake subdir is under ${libdir} instead of ${datadir} for this component.
FILES_${PN}-dev += "${libdir}/${ROS_BPN}/cmake"
