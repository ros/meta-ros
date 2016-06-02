DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
HOMEPAGE = "http://logging.apache.org/log4cxx/"

SRC_URI = "svn://svn.apache.org/repos/asf;module=incubator/log4cxx/trunk;protocol=http"
SRCREV = "1738416"

S = "${WORKDIR}/incubator/log4cxx/trunk"

inherit autotools-brokensep pkgconfig

BBCLASSEXTEND += "native"
