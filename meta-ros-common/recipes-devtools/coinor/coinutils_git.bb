LICENSE = "EPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44f12365016145dc45da7854fe1d6c8e"

SRC_URI = "git://github.com/coin-or/CoinUtils.git;protocol=https;branch=master"

SRCREV = "ffd24f05c068ba84c84eb39de5bb308ed2dc3fb5"

DEPENDS = "coinor-buildtools-native lapack"

PV = "2.11.12+git"

inherit autotools pkgconfig

# configure.ac:27: error: possibly undefined macro: AC_COIN_INITIALIZE
#       If this token and others are legitimate, please use m4_pattern_allow.
#       See the Autoconf documentation.
# configure.ac:35: error: possibly undefined macro: AC_COIN_PROG_CXX
# configure.ac:43: error: possibly undefined macro: AC_COIN_PROG_LIBTOOL
# configure.ac:46: error: possibly undefined macro: AC_COIN_DEBUGLEVEL
# configure.ac:64: error: possibly undefined macro: AC_COIN_CHECK_ISFINITE
# configure.ac:65: error: possibly undefined macro: AC_COIN_CHECK_ISNAN
# configure.ac:97: error: possibly undefined macro: AC_COIN_CHK_LAPACK
# configure.ac:98: error: possibly undefined macro: AC_COIN_CHK_PKG
# configure.ac:103: error: possibly undefined macro: AC_COIN_CHK_LIBM
# configure.ac:104: error: possibly undefined macro: AC_COIN_CHK_ZLIB
# configure.ac:105: error: possibly undefined macro: AC_COIN_CHK_BZLIB
# configure.ac:106: error: possibly undefined macro: AC_COIN_CHK_GNU_READLINE
# configure.ac:109: error: possibly undefined macro: AC_COIN_FINALIZE_FLAGS
# configure.ac:133: error: possibly undefined macro: AC_COIN_DOXYGEN
# configure.ac:154: error: possibly undefined macro: AC_COIN_FINALIZE
do_configure:prepend () {
    mkdir -p ${S}/BuildTools
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/Makemain.inc ${S}/BuildTools
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/*.m4 ${S}/coinor-m4
}

