DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=7c6a629da965ebdfba9f6fdb76ab8ab4"

DEPENDS = "boost"

PR = "r0"

S = "${WORKDIR}/yaml-cpp-release-${PV}"

SRC_URI = "https://github.com/jbeder/yaml-cpp/archive/release-${PV}.tar.gz"
SRC_URI[md5sum] = "2728af8a15e2b2c407730c45b99b274b"
SRC_URI[sha256sum] = "6fb92f6f5925e0af918ffbb90acf19b7b88706ebcd40fc186b7caa76609b6350"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

inherit cmake
