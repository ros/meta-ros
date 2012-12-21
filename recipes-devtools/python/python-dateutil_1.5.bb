DESCRIPTION = "Extensions to the standard Python datetime module"
SECTION = "devel/python"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d82268718c68bda0b091006ec6e583c6"

SRC_URI = "http://labix.org/download/python-dateutil/python-dateutil-${PV}.tar.gz"
SRC_URI[md5sum] = "35f3732db3f2cc4afdc68a8533b60a52"
SRC_URI[sha256sum] = "c08aca7d85f8f8eed61e83b3423b829262c596a9a78f7ca3de0bcee2217d0e3b"

S = "${WORKDIR}/python-dateutil-${PV}"

inherit setuptools

