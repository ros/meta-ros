LICENSE = "EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fa146738cbe7d5c7435f87912e8b77"

SRC_URI = "git://github.com/coin-or/Ipopt.git;protocol=https;branch=stable/3.14"

SRCREV = "43a63412f73d9ad3ff9074d38b49362fc9d7f8f1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

DEPENDS = "coinor-buildtools-native lapack"

do_configure:prepend () {
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/* ${S}/coinor-m4
}
