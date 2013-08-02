DESCRIPTION = "Portable network interface information for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=8376078ca8314aaec5a58b802edf3c15"
SRCNAME = "netifaces"

SRC_URI = "http://alastairs-place.net/projects/netifaces/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "e57e5983f4c286fac5f8068fbfc5c873"
SRC_URI[sha256sum] = "53a711038db3d6e5cf7129d6f751185fd052f830f12f271fbfe17bd2671ab1ec"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
