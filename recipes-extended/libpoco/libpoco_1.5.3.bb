DESCRIPTION = "POCO C++ Libraries"
HOMEPAGE = "http://pocoproject.org"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4267f48fc738f50380cbeeb76f95cebc"

DEPENDS = "expat zlib libpcre openssl"

SRC_URI = "https://github.com/pocoproject/poco/archive/poco-${PV}-release.tar.gz"
SRC_URI[md5sum] = "4636d84055a434fde3a67396bf15924a"
SRC_URI[sha256sum] = "f26bbd7879ad79b45630f8efa20b1c65f0ddf81dc44f169245d512d208c71e53"

S = "${WORKDIR}/poco-poco-${PV}-release"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DPOCO_UNBUNDLED=On"

inherit cmake
