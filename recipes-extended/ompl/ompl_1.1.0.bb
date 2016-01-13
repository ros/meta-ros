DESCRIPTION = "The Open Motion Planning Library (OMPL) consists of a set of sampling-based motion planning algorithms."
HOMEPAGE = "http://ompl.kavrakilab.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=923f436234988118e9a042c42a64323c"

DEPENDS = "boost libeigen"

SRC_URI = "https://bitbucket.org/ompl/ompl/downloads/ompl-1.1.0-Source.tar.gz"
SRC_URI[md5sum] = "2a72c5add9675e164c8370a710627e93"
SRC_URI[sha256sum] = "4d141ad3aa322c65ee7ecfa90017a44a8114955316e159b635fae5b5e7db74f8"

S = "${WORKDIR}/ompl-${PV}-Source"

inherit cmake
