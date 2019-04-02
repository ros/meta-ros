SUMMARY = "Static code analyzer for C/C++"
DESCRIPTION = " Static code analyzer for C/C++."

HOMEPAGE = " http://cppcheck.sourceforge.net/"
BUGTRACKER = " https://trac.cppcheck.net/"
LICENSE = "GPLv3"

inherit native

inherit pkgconfig

DEPENDS = "libpcre-native"

## we don't need debug packages
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

EXTRA_OEMAKE = "HAVE_RULES=yes"

do_compile() {
	oe_runmake
}

FILES_${PN} = "${bindir}/** ${datadir}"


do_install() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}
    install ${B}/cppcheck ${D}${bindir}
    cp -R ${B}/addons ${D}${bindir}
    cp -R ${B}/cfg ${D}${bindir}
    install -D ${B}/htmlreport/cppcheck-htmlreport ${D}${bindir}
    install ${WORKDIR}/cppcheck.sca.description ${D}${datadir}
}
