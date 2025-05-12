LICENSE = "EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fa146738cbe7d5c7435f87912e8b77"

SRC_URI = "git://github.com/coin-or/Ipopt.git;protocol=https;branch=stable/3.14"

SRCREV = "66245ceea9e613cf6ce113d430903b931cc7ff7a"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

DEPENDS = "coinor-buildtools-native lapack"

do_configure:prepend () {
    mkdir -p ${S}/coinor-m4
    cp ${STAGING_DIR_NATIVE}/${datadir}/coinor/* ${S}/coinor-m4
}
