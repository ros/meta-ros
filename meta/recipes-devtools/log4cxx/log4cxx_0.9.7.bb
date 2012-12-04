DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache License, Version 2.0"
HOMEPAGE = "http://logging.apache.org/log4cxx/"
# PV = "0.10.0"
PR = "r1"

SRC_URI = "http://archive.apache.org/dist/logging/log4cxx/log4cxx-0.9.7.tar.gz \
          file://log4cxx097.patch"

#build this:
S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

SRC_URI[md5sum] = "fd09abc90b8c0c8af1d5146a75590792"
SRC_URI[sha256sum] = "5b41b2fc267595bdb0fa4cd1152309413bc70e6d9196293113ebb82751eb7ec6"
