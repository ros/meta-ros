SUMMARY = "Static code analyzer for C/C++"
DESCRIPTION = " Static code analyzer for C/C++."

HOMEPAGE = " http://cppcheck.sourceforge.net/"
BUGTRACKER = " https://trac.cppcheck.net/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit pkgconfig

DEPENDS = "libpcre"

## we don't need debug packages
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

EXTRA_OEMAKE = "HAVE_RULES=yes"

do_compile() {
	oe_runmake
}

FILES:${PN} = "${bindir}/** ${datadir}"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}
    install ${B}/cppcheck ${D}${bindir}
    cp -R ${B}/addons ${D}${bindir}
    cp -R ${B}/cfg ${D}${bindir}
    install -D ${B}/htmlreport/cppcheck-htmlreport ${D}${bindir}
    install ${WORKDIR}/cppcheck.sca.description ${D}${datadir}
}

BBCLASSEXTEND = "native"

SRCREV = "f45cecc303d4bd7c0ec82e42d710deaccef8f3ee"
ROS_BRANCH ?= "branch=main"
SRC_URI = " \
    git://github.com/danmar/cppcheck;${ROS_BRANCH};protocol=https \
    file://0001-makefile.patch \
    file://0002-pkgconfig-instaed-of-pcre-config.patch \
    file://0001-Fix-compilation-with-recent-glibc-where-SIGSTKSZ-is-.patch \
    file://cppcheck.sca.description \
"

S = "${WORKDIR}/git"
