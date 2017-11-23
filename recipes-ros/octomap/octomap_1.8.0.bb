DESCRIPTION = "The OctoMap library implements a 3D occupancy grid mapping approach, providing data structures and mapping algorithms in C++."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9b0e1f01a68f441eeaf7b5e18812d3c8"

SRC_URI = "https://github.com/OctoMap/${BPN}/archive/v${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-Improve-the-generation-of-config.cmake-and-version.c.patch \
           "
SRC_URI[md5sum] = "e341c3ef92c978cc0261158bbafbf46a"
SRC_URI[sha256sum] = "158f66af55bb660a2aa7d0a00c60c9e5320f6594bd0924748af1471d315d5633"

S = "${WORKDIR}/${BP}/${BPN}"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=ON"

inherit cmake
