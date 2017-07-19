DESCRIPTION = "The Open Motion Planning Library (OMPL) consists of a set of sampling-based motion planning algorithms."
HOMEPAGE = "http://ompl.kavrakilab.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=923f436234988118e9a042c42a64323c"

DEPENDS = "boost libeigen"

SRC_URI = "https://github.com/ompl/ompl/archive/1.1.1.tar.gz"
SRC_URI[md5sum] = "f8bb5f25c09c3b6e05444515eb14175a"
SRC_URI[sha256sum] = "31d6f27dd7c033eb83ef792d402f716f27ce393b6a97b621f3acf540c6364bbc"

S = "${WORKDIR}/ompl-${PV}"

inherit cmake

EXTRA_OECMAKE = "-DOMPL_SKIP_RPATH=ON"
