DESCRIPTION = "MAVLink communication library"
LICENSE = "BSD | GPLv3 | LGPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=17;md5=9b511d4c606b1a23e454d3260818d003"

DEPENDS = " \
    boost \
    mavlink \
    console-bridge \
"

RDEPENDS_${PN} = " \
    boost \
    mavlink \
    console-bridge \
"

require mavros.inc

ROS_PKG_SUBDIR = "libmavconn"

SRC_URI += "file://0001-compile-also-with-boost-1.66.0.patch;striplevel=2"
