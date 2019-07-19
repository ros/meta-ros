DESCRIPTION = "GeographicLib is a small set of C++ classes for performing conversions between geographic, UTM, UPS, MGRS, geocentric, and local cartesian coordinates, for gravity (e.g., EGM2008), geoid height, and geomagnetic field (e.g., WMM2010) calculations, and for solving geodesic problems."
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=beda1cf298e14fa7de56a07a83308905" 

DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/distrib/GeographicLib-${PV}.tar.gz"
SRC_URI[md5sum] = "e99153cf41bf64998cc4f91c00aea167"
SRC_URI[sha256sum] = "7203d56123b6f6fb31842295d57b2418f79fb0db9a06f2f65ee9e415c6f0cb70"

S = "${WORKDIR}/GeographicLib-${PV}"

inherit cmake
