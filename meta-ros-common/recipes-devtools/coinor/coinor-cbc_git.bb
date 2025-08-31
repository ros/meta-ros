LICENSE = "EPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44f12365016145dc45da7854fe1d6c8e"

SRC_URI = "git://github.com/coin-or/Cbc.git;protocol=https;branch=master"

PV = "2.10.12+git"
SRCREV = "a5f28a33fc4ee170fe51b3706c0400660b3f2f65"

S = "${WORKDIR}/git"

DEPENDS = "coinor-buildtools-native coinutils coinor-osi coinor-cgl coinor-clp"

inherit autotools pkgconfig

# configure.ac:24: error: possibly undefined macro: AC_COIN_INITIALIZE
#       If this token and others are legitimate, please use m4_pattern_allow.
#       See the Autoconf documentation.
# configure.ac:31: error: possibly undefined macro: AC_COIN_PROG_CXX
# configure.ac:34: error: possibly undefined macro: AC_COIN_PROG_LIBTOOL
# configure.ac:39: error: possibly undefined macro: AC_COIN_RPATH_FLAGS
# configure.ac:46: error: possibly undefined macro: AC_COIN_CHECK_MATH_HDRS
# configure.ac:60: error: possibly undefined macro: AC_COIN_CHK_PKG
# configure.ac:72: error: possibly undefined macro: AC_COIN_CHK_GNU_READLINE
# configure.ac:107: error: possibly undefined macro: AC_COIN_CHK_LIB
# configure.ac:109: error: possibly undefined macro: AC_COIN_FINALIZE_FLAGS
# configure.ac:338: error: possibly undefined macro: AC_COIN_VPATH_LINK
# configure.ac:344: error: possibly undefined macro: AC_COIN_DOXYGEN
# configure.ac:367: error: possibly undefined macro: AC_COIN_FINALIZE
do_configure:prepend () {
    mkdir -p ${S}/BuildTools
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/Makemain.inc ${S}/BuildTools
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/*.m4 ${S}/coinor-m4
}
