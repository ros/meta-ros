LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/License;md5=8c40b6377ed6920e877be2267e3daaf3"

SRC_URI = "git://github.com/nimble-code/Cobra.git;protocol=https;branch=master \
           file://fix-makefile-to-use-compiler-options.patch \
           file://do-not-chain-makefiles.patch \
           file://use-ldlibs.patch \
           file://use-ldflags-for-cobra.patch"

PV = "4.8"
SRCREV = "5af7230ecf29a6c9b46ff1bdd60c5d9e51d032db"

DEPENDS = "bison-native"

S = "${WORKDIR}/git"
B = "${S}"

# EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'"
# LDFLAGS:append = " -Wl,c.ar"

do_compile () {
        cd ${S}/src && oe_runmake all
        cd ${S}/src_app && oe_runmake all
}

do_install () {
        mkdir -p ${D}${datadir}/man/man1
        mkdir -p ${D}${bindir}

        # Based on https://github.com/ament/ament_cobra/blob/main/cobra_vendor/CMakeLists.txt
        cd ${S}/src && oe_runmake install BINDIR="${D}${bindir}" MAN=${S}/src_app
        cd ${S}/src_app && oe_runmake install BINDIR="${D}${bindir}"
}

BBCLASSEXTEND = "native nativesdk"
