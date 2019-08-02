DESCRIPTION = "The URDF (U-Robot Description Format) headers provides core \
data structure headers for URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

ROS_BPN = "urdfdom_headers"

SRC_URI = "https://salsa.debian.org/science-team/urdfdom-headers/-/archive/debian/${PV}/urdfdom-headers-debian-${PV}.tar.gz"

SRC_URI[md5sum] = "9101c3c3e942e262a6a95094813a22c1"
SRC_URI[sha256sum] = "2837029360405719fc16d0b156ce3972074b34977d7dc407fa94260410abe801"
S = "${WORKDIR}/urdfdom-headers-debian-${PV}"

# Taken from https://salsa.debian.org/science-team/urdfdom-headers/blob/debian/1.0.0-1/debian/control:
DEPENDS = " \
    cmake \
"

# This component puts its cmake files under libdir instead of datadir.
FILES_${PN}-dev_prepend = " \
    ${libdir}/${ROS_BPN}/cmake \
"

ALLOW_EMPTY_${PN} = "1"

inherit cmake
# This recipe is generated for ROS 2 distros.
inherit ros_recipe_now_generated
