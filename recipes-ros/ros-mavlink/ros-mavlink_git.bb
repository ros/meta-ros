DESCRIPTION = "MAVLink message marshaling library"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=54ad3cbe91bebcf6b1823970ff1fb97f"

SRC_URI = "git://github.com/mavlink/mavlink-gbp-release.git;branch=release/${ROSDISTRO}/mavlink"
SRCREV = "${AUTOREV}"

SRC_URI += "file://0001-Fix-PKG_NAME-_INCLUDE_DIR-variable.patch"
SRC_URI += "file://0001-do-not-require-python2.patch"

S = "${WORKDIR}/git"

DEPENDS = "${PYTHON_PN}-setuptools-native"

inherit catkin
