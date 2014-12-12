DESCRIPTION = "The Edinburgh Speech Tools Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=9fe1b4db906b7d75f821c72a358638fd"

DEPENDS = "alsa-lib ncurses"

SRC_URI = "http://tts.speech.cs.cmu.edu/awb/20130703/speech_tools-${PV}-current.tar.gz"
SRC_URI[md5sum] = "02863b3ead04a0ade65982a1f34a60bb"
SRC_URI[sha256sum] = "75e203402483b78de635943671aaf6f86cb6f9bf181fc84a931c2a560ade6a7c"

S = "${WORKDIR}/speech_tools"

inherit autotools-brokensep

PARALLEL_MAKE = ""

do_configure_prepend() { 
    #force crosscompilation compiler
    sed -i 's:CC=gcc:CC=${CC}:g' ${S}/config/compilers/gcc_defaults.mak
    sed -i 's:CXX=gcc:CXX=${CC}:g' ${S}/config/compilers/gcc_defaults.mak
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
    sysroot_stage_dir ${WORKDIR}/speech_tools/config ${STAGING_DIR_TARGET}${datadir}/${PN}/config
    sysroot_stage_dir ${WORKDIR}/speech_tools/include ${STAGING_DIR_TARGET}${datadir}/${PN}/include
    sysroot_stage_dir ${WORKDIR}/speech_tools/base_class ${STAGING_DIR_TARGET}${datadir}/${PN}/base_class
    sysroot_stage_dir ${WORKDIR}/speech_tools/lib ${STAGING_DIR_TARGET}${datadir}/${PN}/lib
}

RDEPENDS_${PN} += "perl"
