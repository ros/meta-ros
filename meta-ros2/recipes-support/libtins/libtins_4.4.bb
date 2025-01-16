SUMMARY = "packet crafting and sniffing library"
DESCRIPTION = ""
DESCRIPTION = "High-level, multiplatform C++ network packet sniffing and crafting library."
HOMEPAGE = "http://libtins.github.io/"
SECTION = "examples"
DEPENDS = "libpcap"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dcaaaf1a01e7f9ceb200d383a0d4320c"

SRC_URI = "git://github.com/mfontanini/libtins;branch=master;protocol=https"
SRCREV = "e3aedc56edc7e9f39170c195de9a886a4309b0cb"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

