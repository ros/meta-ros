DESCRIPTION = "A powerful and robust templating system for Python"
SECTION = "devel/python"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"
SRCNAME = "empy"

SRC_URI = "http://www.alcyone.com/software/empy/empy-${PV}.tar.gz"
SRC_URI[md5sum] = "fbb34761cdf9acc4c65e298c9eced395"
SRC_URI[sha256sum] = "99f016af2770c48ab57a65df7aae251360dc69a1514c15851458a71d4ddfea9c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

BBCLASSEXTEND = "native nativesdk"
