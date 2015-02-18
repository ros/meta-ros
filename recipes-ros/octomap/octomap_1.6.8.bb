DESCRIPTION = "The OctoMap library implements a 3D occupancy grid mapping approach, providing data structures and mapping algorithms in C++."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9b0e1f01a68f441eeaf7b5e18812d3c8"

SRC_URI = "https://github.com/OctoMap/${BPN}/archive/v${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "e4f9ab54fecfc031ec160b8989340804"
SRC_URI[sha256sum] = "833adba0d3b203cab0e28a0180490e74bc852a7fea9adf6ee53bbfb8f10bc79a"

S = "${WORKDIR}/${BP}/${BPN}"

EXTRA_OECMAKE += "\
    -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake
