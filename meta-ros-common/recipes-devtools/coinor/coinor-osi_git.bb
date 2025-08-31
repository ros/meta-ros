LICENSE = "EPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44f12365016145dc45da7854fe1d6c8e"

SRC_URI = "git://github.com/coin-or/Osi.git;protocol=https;branch=master"

PV = "0.108.11+git"
SRCREV = "cb16146c414843076e397370d051a168b7c9215d"

S = "${WORKDIR}/git"

DEPENDS = "coinor-buildtools-native coinutils"

inherit autotools pkgconfig

# configure.ac:24: error: possibly undefined macro: AC_COIN_INITIALIZE
#       If this token and others are legitimate, please use m4_pattern_allow.
#       See the Autoconf documentation.
# configure.ac:31: error: possibly undefined macro: AC_COIN_PROG_CXX
# configure.ac:37: error: possibly undefined macro: AC_COIN_PROG_LIBTOOL
# configure.ac:42: error: possibly undefined macro: AC_COIN_RPATH_FLAGS
# configure.ac:49: error: possibly undefined macro: AC_COIN_CHECK_MATH_HDRS
# configure.ac:56: error: possibly undefined macro: AC_COIN_CHK_PKG
# configure.ac:62: error: possibly undefined macro: AC_COIN_FINALIZE_FLAGS
# configure.ac:71: error: possibly undefined macro: AC_COIN_CHK_HERE
# configure.ac:84: error: possibly undefined macro: AC_COIN_CHK_LIBHDR
# configure.ac:187: error: possibly undefined macro: AC_COIN_DOXYGEN
# configure.ac:245: error: possibly undefined macro: AC_COIN_FINALIZE
do_configure:prepend () {
    mkdir -p ${S}/BuildTools
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/Makemain.inc ${S}/BuildTools
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/*.m4 ${S}/coinor-m4
}
