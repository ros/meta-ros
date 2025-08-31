LICENSE = "EPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44f12365016145dc45da7854fe1d6c8e"

SRC_URI = "git://github.com/coin-or/Clp.git;protocol=https;branch=master"

PV = "1.17.10+git"
SRCREV = "e28045d7d35465c4880118538b050e5478e01fa3"

S = "${WORKDIR}/git"

DEPENDS = "coinor-buildtools-native coinutils coinor-osi"

inherit autotools pkgconfig

# configure.ac:24: error: possibly undefined macro: AC_COIN_INITIALIZE
#       If this token and others are legitimate, please use m4_pattern_allow.
#       See the Autoconf documentation.
# configure.ac:31: error: possibly undefined macro: AC_COIN_PROG_CXX
# configure.ac:37: error: possibly undefined macro: AC_COIN_PROG_LIBTOOL
# configure.ac:42: error: possibly undefined macro: AC_COIN_RPATH_FLAGS
# configure.ac:49: error: possibly undefined macro: AC_COIN_CHECK_MATH_HDRS
# configure.ac:58: error: possibly undefined macro: AC_COIN_CHK_PKG
# configure.ac:60: error: possibly undefined macro: AC_MSG_ERROR
# configure.ac:83: error: possibly undefined macro: AC_COIN_CHK_LIBHDR
# configure.ac:113: error: possibly undefined macro: AC_COIN_TRY_LINK
# configure.ac:114: error: possibly undefined macro: AC_COIN_DEFINENAMEMANGLING
# configure.ac:116: error: possibly undefined macro: AC_DEFINE
# configure.ac:127: error: possibly undefined macro: AC_COIN_CHK_GNU_READLINE
# configure.ac:135: error: possibly undefined macro: AC_COIN_EXAMPLE_FILES
# configure.ac:142: error: possibly undefined macro: AC_COIN_DOXYGEN
# configure.ac:149: error: possibly undefined macro: AC_COIN_FINALIZE_FLAGS
# configure.ac:150: error: possibly undefined macro: AC_COIN_CHK_HERE
# configure.ac:175: error: possibly undefined macro: AC_COIN_FINALIZE
do_configure:prepend () {
    mkdir -p ${S}/BuildTools
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/Makemain.inc ${S}/BuildTools
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/*.m4 ${S}/coinor-m4
}
