DESCRIPTION = "Independent BSON codec for Python that doesn't depend on MongoDB"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db7a1eab1d8b38da1e06abbf08d2498d"

SRC_URI = "https://github.com/py-bson/bson/archive/${PV}.tar.gz;downloadfilename=py-bson_{PV}.tar.gz"
SRC_URI[md5sum] = "9319364259c7b4eb77a218f7948f9fe8"
SRC_URI[sha256sum] = "b84569685426374242dfc7d4fa08c9694951e85203d085c256866cf87dcb0b7e"

S = "${WORKDIR}/bson-${PV}"

inherit setuptools
