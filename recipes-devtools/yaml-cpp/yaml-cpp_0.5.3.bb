DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a8aaf0595c2efc1a9c2e0913e9c1a2c"

DEPENDS = "boost"

PR = "r0"

S = "${WORKDIR}/yaml-cpp-release-${PV}"

SRC_URI = "https://github.com/jbeder/yaml-cpp/archive/release-${PV}.tar.gz"
SRC_URI[md5sum] = "64200ca0bf5e0af065804d8d3e8f6d42"
SRC_URI[sha256sum] = "ac50a27a201d16dc69a881b80ad39a7be66c4d755eda1f76c3a68781b922af8f"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

inherit cmake
