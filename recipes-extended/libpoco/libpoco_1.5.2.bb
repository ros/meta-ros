DESCRIPTION = "POCO C++ Libraries"
HOMEPAGE = "http://pocoproject.org"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"

DEPENDS = "expat zlib libpcre openssl"

SRC_URI = "https://github.com/pocoproject/poco/archive/poco-${PV}-release.tar.gz"
SRC_URI[md5sum] = "4ed751311fe4eb437a485139fcfdf558"
SRC_URI[sha256sum] = "315f0947b3494172cb2833d7c978fc24f16f6f10dd1a5299e83b81fee7b62f27"

SRC_URI += "file://0001-correct-path-for-CONFIGURE_FILE-in-CMakeLists.txt.patch"

S = "${WORKDIR}/poco-poco-${PV}-release"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

inherit cmake
