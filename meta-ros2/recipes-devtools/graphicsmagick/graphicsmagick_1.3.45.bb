SUMMARY = "Swiss army knife of image processing"
HOMEPAGE = "http://www.graphicsmagick.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=5ad9b143299aada53e485843fbafd494"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/GraphicsMagick-${PV}.tar.xz \
           file://remove-host-build-info-from-version-command.patch"

SRC_URI[md5sum] = "5eb76e9af7b887a8828fce11aa1e2f1c"
SRC_URI[sha256sum] = "dcea5167414f7c805557de2d7a47a9b3147bcbf617b91f5f0f4afe5e6543026b"

S = "${WORKDIR}/GraphicsMagick-${PV}"

inherit autotools

FILES:${PN} += "${datadir}/GraphicsMagick-1.3.45/config ${libdir}/GraphicsMagick-1.3.45/config"

EXTRA_OECONF += "--enable-static=no --enable-shared=yes"

CACHED_CONFIGUREVARS += " ac_cv_path_MVDelegate='${bindir}/mv'"

do_install:append() {
    sed -i -e 's|-ffile-prefix-map[^ ]*||g; s|-fdebug-prefix-map[^ ]*||g; s|-fmacro-prefix-map[^ ]*||g; s|${STAGING_DIR_TARGET}||g' ${D}${libdir}/pkgconfig/*.pc

    # The config scripts contain the build configuration and are not needed on the target
    # The pkgconfig files are available as an alternative
    rm ${D}${bindir}/GraphicsMagick-config
    rm ${D}${bindir}/GraphicsMagick++-config
}
