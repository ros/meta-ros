LICENSE = "EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fa146738cbe7d5c7435f87912e8b77"

SRC_URI = "git://github.com/coin-or-tools/BuildTools.git;protocol=https;branch=master"

SRCREV = "20208f47f7bbc0056a92adefdfd43fded969f674"

PV = "0.8.10+git"
S = "${WORKDIR}/git"

do_install () {
    install -d -m 0755 ${D}/${datadir}/coinor
    install -D -m 0755 ${S}/coin.m4 ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin-functions ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin_chk_lapack.m4 ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin_chk_libhdr.m4 ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin_chk_pkg.m4 ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin_fortran.m4 ${D}${datadir}/coinor
    install -D -m 0755 ${S}/coin_math.m4 ${D}${datadir}/coinor
}

BBCLASSEXTEND = "native nativesdk"
