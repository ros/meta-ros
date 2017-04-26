DESCRIPTION = "This package contains the basic libraries shared by the CMU Sphinx \
trainer and all the Sphinx decoders (Sphinx-II, Sphinx-III, and \
PocketSphinx), as well as some common utilities for manipulating \
acoustic feature and audio files."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=c550e8ca1106e5eeaf4e2b4cbf960fcf"

SRC_URI[md5sum] = "7335d233f7ad4ecc4b508aec7b5dc101"
SRC_URI[sha256sum] = "55708944872bab1015b8ae07b379bf463764f469163a8fd114cbb16c5e486ca8"

require cmusphinx.inc

SRC_URI += "file://0001-TESTS-srcdir-remove.patch"

DEPENDS = "libsndfile1 alsa-lib libsamplerate0"

EXTRA_OECONF = " --without-python"

do_install_append () {
    #remove egg-info
    rm -rf ${D}/${PYTHON_SITEPACKAGES_DIR}/*.egg-info
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/sphinxbase.so"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug/*"
