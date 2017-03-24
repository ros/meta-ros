DESCRIPTION = "Orocos Kinematics and Dynamics C++ Library"
SECTION = "devel"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2"

DEPENDS = "libeigen"

require kdl.inc

FILES_${PN}-dev += "${datadir}/orocos_kdl/*"
