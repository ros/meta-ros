LICENSE = "EPL-1.0 & EPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44f12365016145dc45da7854fe1d6c8e"

SRC_URI = "git://github.com/coin-or/Cgl.git;protocol=https;branch=master"

SRCREV = "581c780d8fcda5e02f3c8ef2975bc6804555fa41"

DEPENDS = "coinor-buildtools-native coinutils coinor-osi coinor-clp"

PV = "0.60.9+git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

# configure.ac:24: error: possibly undefined macro: AC_COIN_INITIALIZE
#       If this token and others are legitimate, please use m4_pattern_allow.
#       See the Autoconf documentation.
# configure.ac:31: error: possibly undefined macro: AC_COIN_PROG_CXX
# configure.ac:37: error: possibly undefined macro: AC_COIN_PROG_LIBTOOL
# configure.ac:42: error: possibly undefined macro: AC_COIN_RPATH_FLAGS
# configure.ac:49: error: possibly undefined macro: AC_COIN_CHECK_MATH_HDRS
# configure.ac:82: error: possibly undefined macro: AC_COIN_CHK_PKG
# configure.ac:101: error: possibly undefined macro: AC_COIN_FINALIZE_FLAGS
# configure.ac:133: error: possibly undefined macro: AC_COIN_DOXYGEN
# configure.ac:176: error: possibly undefined macro: AC_COIN_FINALIZE
do_configure:prepend () {
    mkdir -p ${S}/BuildTools
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/Makemain.inc ${S}/BuildTools
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/*.m4 ${S}/coinor-m4
}
