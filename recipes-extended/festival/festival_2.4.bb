DESCRIPTION = "University of Edinburgh's Festival Speech Synthesis Systems is a free software \
multi-lingual speech synthesis workbench that runs on multiple-platforms offering black box text to speech, \
as well as an open architecture for research in speech synthesis. \
It designed as a component of large speech technology systems."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=929d21c5ebf729ca3fa206e0b64ff0c7"

DEPENDS = "speech-tools"

SRC_URI = "http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/${PN}-${PV}-release.tar.gz;name=festival \
    http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/festlex_CMU.tar.gz;name=CMU \
    http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/festlex_OALD.tar.gz;name=OALD \
    http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/festlex_POSLEX.tar.gz;name=POSLEX \
    http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/voices/festvox_kallpc16k.tar.gz;name=kallpc16k \
    http://www.cstr.ed.ac.uk/downloads/${PN}/${PV}/voices/festvox_rablpc16k.tar.gz;name=rablpc16k \
    "
SRC_URI[festival.md5sum] = "49707d2f6744d5a67f81a96c36f7cb59"
SRC_URI[festival.sha256sum] = "1e47f293e0857ffde2bccead97947c040ea0b35ea12dd5796edb51583e5e5d84"
SRC_URI[CMU.md5sum] = "6a2ee4fed7c3ebedf197a3b8524ccb87"
SRC_URI[CMU.sha256sum] = "c19430919bca45d5368cd4c82af6153fbcc96a487ebd30b78b5f3c08718b7c07"
SRC_URI[OALD.md5sum] = "84af32a914d996f57bc4cb36fe8cdc97"
SRC_URI[OALD.sha256sum] = "e33a345390d4c76f8b987b06a5332bcdd0b168cf67c95ddc3270f9163cbe61f8"
SRC_URI[POSLEX.md5sum] = "aa80f9250065b318325f16fdad3a4484"
SRC_URI[POSLEX.sha256sum] = "e7c6e3642dbd5b0d64942bc015a986fdd6244a79e51ec2e8309e63d569e49ea3"
SRC_URI[kallpc16k.md5sum] = "3869af78f473b616601cac3fa83cc14e"
SRC_URI[kallpc16k.sha256sum] = "7a357c34086fbba8b813f9750f6b5ba13e2a00478a0a2e78a97981cb76395578"
SRC_URI[rablpc16k.md5sum] = "34cb2478f5b8fa1ed02f5cbb496c1dcd"
SRC_URI[rablpc16k.sha256sum] = "a017ef70f6d3e64d51d3772ab438eb47a26b529b456dae3cea18936925ec20e8"

S = "${WORKDIR}/${PN}"

inherit autotools-brokensep

#disable parallel make (make -j), as festival cannot handle that
PARALLEL_MAKE = ""

do_configure_prepend() { 
    #point to speech-tools in sysroots
    sed -i 's:EST=$(TOP)/../speech_tools:EST=${STAGING_DIR_TARGET}${datadir}/speech-tools:g' ${S}/config/config.in

    #exclude experimental includes
    sed -i 's:ALSO_INCLUDE:#ALSO_INCLUDE:g' ${S}/config/config.in

    #fix hardcoded library path
    sed -i 's:FTLIBDIR = $(FESTIVAL_HOME)/lib:FTLIBDIR = ${datadir}/festival:g' ${S}/config/project.mak

    #fix audsp path
    sed -i 's:audfds = pipe_open("audsp"): audfds = pipe_open("${libdir}/festival/audsp"):g' ${S}/src/arch/festival/audspio.cc
}

do_configure_append() { 
    #suppress building of doc - generates error
    sed -i 's:BUILD_DIRS = src lib examples bin doc:BUILD_DIRS = src lib examples bin:g' ${S}/Makefile 

    #fix hardcoded bin path
    sed -i 's:exec "$(FESTIVAL_HOME)/bin/festival:exec "${bindir}/festival:g' ${S}/examples/Makefile
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/bin/festival ${D}${bindir} 
    install -m 0755 ${S}/bin/festival_client ${D}${bindir}
    install -m 0755 ${S}/bin/text2wave ${D}${bindir}

    install -m 0755 -d ${D}${libdir}/festival 
    install -m 0755 ${S}/lib/etc/unknown_*/audsp ${D}${libdir}/festival

    install -m 0755 -d ${D}${datadir}/festival
    install -m 0644 ${S}/lib/*scm ${D}${datadir}/festival
    install -m 0644 ${S}/lib/*gram ${D}${datadir}/festival
    install -m 0644 ${S}/lib/*grambin ${D}${datadir}/festival
    install -m 0644 ${S}/lib/*dtd ${D}${datadir}/festival
    install -m 0644 ${S}/lib/sable-latin.ent ${D}${datadir}/festival
    install -m 0644 ${S}/lib/festival.el ${D}${datadir}/festival
    install -m 0644 ${S}/lib/speech.properties ${D}${datadir}/festival

    install -m 0755 -d ${D}${datadir}/festival/multisyn
    install -m 0644 ${S}/lib/multisyn/*scm ${D}${datadir}/festival/multisyn

    cp -a ${S}/lib/dicts ${D}${datadir}/festival
    cp -a ${S}/lib/voices ${D}${datadir}/festival
}
