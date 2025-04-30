
AUTHOR = "Mark Choi <afewgoodman.choi@gmail.com>"
SUMMARY = "Ipopt (Interior Point OPTimizer, pronounced eye-pea-Opt)"
DESCRIPTION = "A software package for large-scale nonlinear optimization."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fa146738cbe7d5c7435f87912e8b77"

inherit pkgconfig

DEPENDS = " \
  lapack \
"

BRANCH = "branch=stable/3.14"
SRC_URI = "gitsm://github.com/coin-or/Ipopt.git;${BRANCH};protocol=https" 
SRCREV = "66245ceea9e613cf6ce113d430903b931cc7ff7a"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

do_configure[cleandirs] = "${B}"

BBCLASSEXTEND = "native nativesdk"


EXTRA_OECONF = " \
    --target=${TARGET_SYS} \
    --host=${BUILD_SYS} \
    --prefix=${prefix} \
"
EXTRA_OECONF:append = " \
    --disable-dependency-tracking \
    --disable-option-checking \
"

do_configure () {

    cd ${B}; ../git/configure ${EXTRA_OECONF}
}

do_compile() {
  oe_runmake
}

do_install() {
  oe_runmake install DESTDIR='${D}'
}

