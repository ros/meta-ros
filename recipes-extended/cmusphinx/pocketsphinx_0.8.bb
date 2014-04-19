DESCRIPTION = "This is PocketSphinx, one of Carnegie Mellon University's open source \
large vocabulary, speaker-independent continuous speech recognition engine."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6601be289d6bcad899b6e71623ce2862"

DEPENDS = "sphinxbase gst-plugins-good"

SRC_URI[md5sum] = "9f6fb6277d57fb33d2c49d4184587d26"
SRC_URI[sha256sum] = "874c4c083d91c8ff26a2aec250b689e537912ff728923c141c4dac48662cce7a"

require cmusphinx.inc

do_configure_prepend () {
    #force build of gstreamer plugin
    sed -i 's:AM_CONDITIONAL(BUILD_GST, test x$cross_compiling != xyes && test "x$HAVE_GST" = "xyes"):AM_CONDITIONAL(BUILD_GST, test "x$HAVE_GST" = "xyes"):g' ${S}/configure.in
}

do_install_append () {
    #remove egg-info
    rm -rf ${D}/${PYTHON_SITEPACKAGES_DIR}/*.egg-info
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/pocketsphinx.so"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug/*"

PACKAGES += "gstreamer0.10-${PN} gstreamer0.10-${PN}-dbg gstreamer0.10-${PN}-staticdev"
FILES_gstreamer0.10-${PN} += "${libdir}/gstreamer-0.10/libgstpocketsphinx.so"
FILES_gstreamer0.10-${PN}-staticdev += "${libdir}/gstreamer-0.10/libgstpocketsphinx.a \
					${libdir}/gstreamer-0.10/libgstpocketsphinx.la"
FILES_gstreamer0.10-${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
