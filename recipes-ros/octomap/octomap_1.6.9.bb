DESCRIPTION = "The OctoMap library implements a 3D occupancy grid mapping approach, providing data structures and mapping algorithms in C++."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9b0e1f01a68f441eeaf7b5e18812d3c8"

SRC_URI = "https://github.com/OctoMap/${BPN}/archive/v${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "3cba6c41544c89a8b51610bdec610f00"
SRC_URI[sha256sum] = "3383ee9c6b18577c860d747369c84814058e2a9413f7d482846b1e02ce76f0f7"

S = "${WORKDIR}/${BP}/${BPN}"

EXTRA_OECMAKE += "\
    -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake
