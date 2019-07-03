DESCRIPTION = "The Edinburgh Speech Tools Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=5a04850e2bcfae66d6cae547274d72c3"

DEPENDS = "alsa-lib ncurses"

SRC_URI = "http://www.cstr.ed.ac.uk/downloads/festival/${PV}/speech_tools-${PV}-release.tar.gz"
SRC_URI[md5sum] = "3d60e563135363eb2548d947f7ef4e14"
SRC_URI[sha256sum] = "fbc2482c443919aa79d2e599d6a5faee4e793df55a79ef377f1dc7e8ba237010"

S = "${WORKDIR}/speech_tools"

inherit autotools-brokensep

PARALLEL_MAKE = ""

EXTRA_OEMAKE = "CC='${CC}' CXX='${CXX} ${LDFLAGS}'"

do_configure_prepend() {
    # respect CC and CXX from EXTRA_OEMAKE
    sed -i '/^CC=gcc/d; /^CXX=gcc$/d' ${S}/config/compilers/gcc_defaults.mak
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/bin/* ${D}${bindir}

    install -m 0755 -d ${D}${libdir} 
    install -m 0644 ${S}/lib/libestools.a ${D}${libdir} 
    install -m 0644 ${S}/lib/libestbase.a ${D}${libdir} 
    install -m 0644 ${S}/lib/libeststring.a ${D}${libdir} 
}

SYSROOT_PREPROCESS_FUNCS += "speechtools_sysroot_preprocess"

#stage speech_tools directories for usage by festival
speechtools_sysroot_preprocess() {
    sysroot_stage_dir ${WORKDIR}/speech_tools/config ${SYSROOT_DESTDIR}${datadir}/${PN}/config
    sysroot_stage_dir ${WORKDIR}/speech_tools/include ${SYSROOT_DESTDIR}${datadir}/${PN}/include
    sysroot_stage_dir ${WORKDIR}/speech_tools/base_class ${SYSROOT_DESTDIR}${datadir}/${PN}/base_class
    sysroot_stage_dir ${WORKDIR}/speech_tools/lib ${SYSROOT_DESTDIR}${datadir}/${PN}/lib
}

RDEPENDS_${PN} += "perl"
