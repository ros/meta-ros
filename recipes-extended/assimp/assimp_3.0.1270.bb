DESCRIPTION = "Open Asset Import Library"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bc4231a2268da8fc55525ad119638a87"

DEPENDS = "boost"

SRC_URI = "http://sourceforge.net/projects/assimp/files/assimp-3.0/assimp--${PV}-source-only.zip"
SRC_URI[md5sum] = "52aa4cf4e34e6b2a9c5f6c0b3c319af1"
SRC_URI[sha256sum] = "ac29beb596db97df57451a5503afaf2d8b4366522842a6914da89644927a1423"

S = "${WORKDIR}/assimp--${PV}-source-only"

inherit cmake

FILES_${PN}-dev += "${libdir}/cmake/assimp-3.0/*.cmake"
