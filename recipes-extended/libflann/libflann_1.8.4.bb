DESCRIPTION = "a library for performing fast approximate nearest neighbor searches in high dimensional spaces"
AUTHOR = "Marius Muja and David G. Lowe"
HOMEPAGE = "http://www.cs.ubc.ca/~mariusm/index.php/FLANN/FLANN"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=040a44ba915aa6b3b099ea189c7b7e20"

SRC_URI = "http://people.cs.ubc.ca/~mariusm/uploads/FLANN/flann-1.8.4-src.zip"
SRC_URI[md5sum] = "a0ecd46be2ee11a68d2a7d9c6b4ce701"
SRC_URI[sha256sum] = "dfbb9321b0d687626a644c70872a2c540b16200e7f4c7bd72f91ae032f445c08"

S = "${WORKDIR}/flann-${PV}-src"

inherit cmake
