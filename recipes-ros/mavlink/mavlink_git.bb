DESCRIPTION = "MAVLink message marshaling library"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=54ad3cbe91bebcf6b1823970ff1fb97f"

DEPENDS = "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-future-native"

SRC_URI = "git://github.com/mavlink/mavlink-gbp-release.git;branch=release/kinetic/mavlink \
    file://0001-do-not-require-python2.patch \
    file://0002-provide-path-to-find-mavgen_c.patch \
"
SRCREV = "7dbef3644782a4297fec76a4a2f7a61705dd624d"
PV = "1.0.9+git${SRCPV}"

S = "${WORKDIR}/git"

inherit catkin
