DESCRIPTION = "Python interface to PROJ.4 library"
SECTION = "devel/python"
LICENSE = "ISC & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=77d9726a341183ab262b28b3d66dfd94 \
                    file://LICENSE_proj4;md5=74d9aaec5fa0cd734341e8c4dc91b608"
SRCNAME = "pyproj"

SRC_URI = "http://pypi.python.org/packages/source/p/pyproj/pyproj-${PV}.tar.gz"
SRC_URI[md5sum] = "027345e3c033fa400e0e64a1c80d34c9"
SRC_URI[sha256sum] = "53fa54c8fa8a1dfcd6af4bf09ce1aae5d4d949da63b90570ac5ec849efaf3ea8"

S = "${WORKDIR}/${SRCNAME}-${PV}"
