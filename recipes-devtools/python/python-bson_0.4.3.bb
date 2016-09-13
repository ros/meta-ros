DESCRIPTION = "Independent BSON codec for Python that doesn't depend on MongoDB"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db7a1eab1d8b38da1e06abbf08d2498d"

SRC_URI = "https://github.com/py-bson/bson/archive/${PV}.tar.gz;downloadfilename=py-bson_${PV}.tar.gz"
SRC_URI[md5sum] = "989acb13782d20c71b8bae03d600a6da"
SRC_URI[sha256sum] = "dcdcf3e8a01ac13375faf791e1ed47ee178c0ec19332252ba539a3a131ca7739"

S = "${WORKDIR}/bson-${PV}"

inherit setuptools
