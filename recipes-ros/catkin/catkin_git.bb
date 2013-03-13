DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg"

SRC_URI = "git://github.com/ros/${BPN}.git \
           "

SRCREV = "cbe6a0ce3ac6d13914d3b4b010148f72e7984149"
SRCREV = "e54faacad535791a2aed2f37d1a7ff18249c61cd"
PV = "0.5.63+gitr${SRCPV}"

S = "${WORKDIR}/git"

inherit catkin

FILES_${PN}-dev += "\
    ${datadir}/eigen/cmake \
    ${datadir}/ros/cmake \
    ${prefix}/.catkin \
    ${prefix}/.rosinstall \
    ${prefix}/_setup_util.py \
    ${prefix}/env.sh \
    ${prefix}/setup.* \
    "

BBCLASSEXTEND += "native"
