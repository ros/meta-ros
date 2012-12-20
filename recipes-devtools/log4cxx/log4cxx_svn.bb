DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache License Version 2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
HOMEPAGE = "http://logging.apache.org/log4cxx/"

SRCREV = "${AUTOREV}"
PV = "0.0+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.apache.org/repos/asf/logging/log4cxx/;protocol=http;module=trunk"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

SRC_URI[md5sum] = "b30ffb8da3665178e68940ff7a61084c"
SRC_URI[sha256sum] = "0de0396220a9566a580166e66b39674cb40efd2176f52ad2c65486c99c920c8c"
