DESCRIPTION = "Fast Library for Approximate Nearest Neighbors"
AUTHOR = "Marius Muja and David G. Lowe"
HOMEPAGE = "http://www.cs.ubc.ca/~mariusm/index.php/FLANN/FLANN"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=395adad2339bd9ce5fef13d564a9681c"

SRC_URI = "https://github.com/mariusmuja/flann/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "73adef1c7bf8e8b978987e7860926ea6"
SRC_URI[sha256sum] = "b23b5f4e71139faa3bcb39e6bbcc76967fbaf308c4ee9d4f5bfbeceaa76cc5d3"

S = "${WORKDIR}/flann-${PV}"

inherit cmake
