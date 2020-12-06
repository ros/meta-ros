DESCRIPTION = "The URDF (U-Robot Description Format) library provides core \
data structures and a simple XML parsers for populating the class data \
structures from an URDF file."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

ROS_BPN = "urdfdom"

SRC_URI = "https://salsa.debian.org/science-team/urdfdom/-/archive/debian/${PV}/urdfdom-debian-${PV}.tar.gz"
SRC_URI[md5sum] = "22983da597aae07ae1c99bafa4b62869"
SRC_URI[sha256sum] = "8480c81da21fc2ef5a0d40e096184dd4bbdb8f28df5f44707e21c26d7e176284"
S = "${WORKDIR}/urdfdom-debian-${PV}"

# Taken from https://salsa.debian.org/science-team/urdfdom/blob/debian/1.0.0-2/debian/control:
DEPENDS = " \
    cmake \
    libtinyxml \
    console-bridge \
    urdfdom-headers \
    ${PYTHON_PN}-mock \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-lxml \
"

inherit python3-dir

# This component puts its cmake files under libdir instead of datadir.
FILES_${PN}-dev_prepend = " \
    ${libdir}/${ROS_BPN}/cmake \
"

inherit cmake
# This recipe is generated for ROS 2 distros.
inherit ros_recipe_now_generated

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES_append = " *.cmake"
