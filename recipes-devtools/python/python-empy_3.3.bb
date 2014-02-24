DESCRIPTION = "A powerful and robust templating system for Python"
SECTION = "devel/python"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"
SRCNAME = "empy"

SRC_URI = "http://www.alcyone.com/software/empy/empy-${PV}.tar.gz"
SRC_URI[md5sum] = "e7b518a6fc4fd28fef87726cdb003118"
SRC_URI[sha256sum] = "c625436d03cff8adbbade639d14a2df9bc4c4de99ec3a821ad4d6eeb66ade805"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

BBCLASSEXTEND = "native"
