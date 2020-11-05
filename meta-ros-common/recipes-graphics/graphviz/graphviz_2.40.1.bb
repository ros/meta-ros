SUMMARY = "Graph Visualization Tools"
HOMEPAGE = "http://www.graphviz.org"
LICENSE = "EPL-1.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=9109f5fc16cf963fb3cdd32781b3ce04"

DEPENDS = " \
    intltool-native \
    bison-native \
    groff-native \
    libtool \
    gdk-pixbuf \
    librsvg \
    cairo \
    pango \
    expat \
    freetype \
"
DEPENDS_append_class-target = " ${BPN}-native"

inherit autotools-brokensep pkgconfig gettext

SRC_URI = "git://gitlab.com/graphviz/graphviz.git;protocol=https"
SRCREV = "67cd2e5121379a38e0801cc05cce5033f8a2a609"

# Use native mkdefs
SRC_URI_append_class-target = " file://0001-Use-native-mkdefs.patch"

S = "${WORKDIR}/git"

EXTRA_OECONF_class-target = "\
                --with-expatincludedir=${STAGING_INCDIR} \
                --with-expatlibdir=${STAGING_LIBDIR} \
                --without-included-ltdl \
                --disable-java \
                --disable-r \
                --disable-sharp \
                "
CFLAGS_append_class-target = " -D_typ_ssize_t=1 -D_long_double=1"
do_configure_prepend() {
    cd ${S}
    # create version.m4 and ignore libtoolize errors
    ./autogen.sh NOCONFIG || true
}

do_install_append_class-native() {
    # install mkdefs for target build
    install -m755 ${B}/lib/gvpr/mkdefs ${D}${bindir}
}

FILES_SOLIBSDEV_append = " ${libdir}/graphviz/lib*${SOLIBSDEV}"

BBCLASSEXTEND = "native"
