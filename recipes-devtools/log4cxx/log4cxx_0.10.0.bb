DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
HOMEPAGE = "http://logging.apache.org/log4cxx/"
PR = "r0"

SRC_URI = "http://archive.apache.org/dist/logging/log4cxx/0.10.0/apache-log4cxx-0.10.0.tar.gz \
  file://0001-log4cxx_0-10-0_add-missing-includes.patch \
  file://0002-Remove-duplicates-from-makefile.patch \
  file://0003-log4cxx-0.10.0-add_stdio_header.patch"

S = "${WORKDIR}/apache-${PN}-${PV}"

inherit autotools pkgconfig

SRC_URI[md5sum] = "b30ffb8da3665178e68940ff7a61084c"
SRC_URI[sha256sum] = "0de0396220a9566a580166e66b39674cb40efd2176f52ad2c65486c99c920c8c"
