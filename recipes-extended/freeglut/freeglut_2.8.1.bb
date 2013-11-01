DESCRIPTION = "freeglut is a completely OpenSourced alternative to the OpenGL Utility Toolkit (GLUT) library."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=89c0b58a3e01ce3d8254c9f59e78adfb"

DEPENDS = "libglu libxi"

SRC_URI = "http://downloads.sourceforge.net/project/freeglut/freeglut/${PV}/freeglut-${PV}.tar.gz"
SRC_URI[md5sum] = "918ffbddcffbac83c218bc52355b6d5a"
SRC_URI[sha256sum] = "dde46626a62a1cd9cf48a11951cdd592e7067c345cffe193a149dfd47aef999a"

S = "${WORKDIR}/freeglut-${PV}"

inherit autotools
