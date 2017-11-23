DESCRIPTION = "MAVLink message marshaling library"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=54ad3cbe91bebcf6b1823970ff1fb97f"

DEPENDS = "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-future-native"

SRC_URI = "git://github.com/mavlink/mavlink-gbp-release.git;branch=release/kinetic/mavlink"
SRCREV = "release/kinetic/mavlink/2017.8.8-0"

SRC_URI += "file://0001-do-not-require-python2.patch"
SRC_URI += "file://0002-provide-path-to-find-mavgen_c.patch"

S = "${WORKDIR}/git"

inherit catkin
