DESCRIPTION = "The Edinburgh Speech Tools Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=9fe1b4db906b7d75f821c72a358638fd"

DEPENDS = "alsa-lib ncurses"

SHRT_VER = "${@oe.utils.trim_version("${PV}", 2)}"
SNAPSHOT = "${@d.getVar('PV').split('.')[2]}"

SRC_URI = "http://tts.speech.cs.cmu.edu/awb/${SNAPSHOT}/speech_tools-${SHRT_VER}-current.tar.gz;downloadfilename=speech_tools-${PV}.tar.gz \
    file://remove.siod_fringe_init.patch \
"
SRC_URI[md5sum] = "1e6878a0ecc5bde6c2f4c91ae0113547"
SRC_URI[sha256sum] = "26c08519313cd83f9a54daf3a86e6924e2797f3991af222fa6dcb61812815783"

S = "${WORKDIR}/speech_tools"

inherit autotools-brokensep

PARALLEL_MAKE = ""

do_configure_prepend() {
    #force crosscompilation compiler
    sed -i 's:CC=gcc:CC=${CC}:g' ${S}/config/compilers/gcc_defaults.mak
    sed -i 's:CXX=gcc:CXX=${CC} ${LDFLAGS}:g' ${S}/config/compilers/gcc_defaults.mak
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/bin/* ${D}${bindir}

    install -m 0755 -d ${D}${libdir}
    install -m 0644 ${S}/lib/libestools.a ${D}${libdir}
    install -m 0644 ${S}/lib/libestbase.a ${D}${libdir}
    install -m 0644 ${S}/lib/libeststring.a ${D}${libdir}

    # speech_tools directories for usage by festival
    install -m 0755 -d ${D}${datadir}/${BPN}
    cp -R --no-dereference --preserve=mode,links -v ${S}/config ${S}/include ${S}/base_class ${S}/lib ${D}${datadir}/${BPN}
}

PACKAGE_BEFORE_PN =+ "${PN}-source"

# ERROR: speech-tools-2.3.20131016-r0 do_package_qa: QA Issue: non -staticdev package contains static .a library: speech-tools-source path '/work/raspberrypi4-webos-linux-gnueabi/speech-tools/2.3.20131016-r0/packages-split/speech-tools-source/usr/share/speech-tools/lib/libestbase.a'
# non -staticdev package contains static .a library: speech-tools-source path '/work/raspberrypi4-webos-linux-gnueabi/speech-tools/2.3.20131016-r0/packages-split/speech-tools-source/usr/share/speech-tools/lib/libeststring.a'
# non -staticdev package contains static .a library: speech-tools-source path '/work/raspberrypi4-webos-linux-gnueabi/speech-tools/2.3.20131016-r0/packages-split/speech-tools-source/usr/share/speech-tools/lib/libestools.a' [staticdev]
INSANE_SKIP_${PN}-source += "staticdev"

FILES_${PN}-source = "${datadir}/${BPN}"

SYSROOT_DIRS_append = " ${datadir}/${BPN}"

RDEPENDS_${PN} += "perl"
