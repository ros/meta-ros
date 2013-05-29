DESCRIPTION = "C++ class libraries and frameworks for building network- and internet-based applications"
HOMEPAGE = "http://pocoproject.org/"
SECTION = "libs"

LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "http://pocoproject.org/releases/poco-${PV}/poco-${PV}p1.tar.gz"
SRC_URI[md5sum] = "8d9cf241dfa7c99842a7ef73c207994b"
SRC_URI[sha256sum] = "f9eddd5e7f963693e9da008a2992f211630560856edfc0f954532b0f42fc66e7"

S = "${WORKDIR}/poco-${PV}p1"

inherit autotools
