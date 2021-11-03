DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
HOMEPAGE = "http://logging.apache.org/log4cxx/"

SRC_URI = "git://git-wip-us.apache.org/repos/asf/logging-log4cxx.git;protocol=https;branch=master"
SRCREV = "03c581216a469eb2bc5cabaa686199504d257af0"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

BBCLASSEXTEND += "native"
