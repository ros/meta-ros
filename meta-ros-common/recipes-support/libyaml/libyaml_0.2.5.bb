SUMMARY = "LibYAML is a YAML 1.1 parser and emitter written in C."
DESCRIPTION = "LibYAML is a C library for parsing and emitting data in YAML 1.1, \
a human-readable data serialization format. "
HOMEPAGE = "https://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://License;md5=7bbd28caa69f81f5cd5f48647236663d"

SRC_URI = "https://pyyaml.org/download/libyaml/yaml-${PV}.tar.gz"
SRC_URI[sha256sum] = "c642ae9b75fee120b2d96c712538bd2cf283228d2337df2cf2988e3c02678ef4"

SRC_URI += "file://0001-use-cmake.patch"

S = "${WORKDIR}/yaml-${PV}"

inherit cmake

EXTRA_OECMAKE += "-DINSTALL_CMAKE_DIR=${baselib}/cmake/yaml \
                  -DBUILD_TESTING=OFF \
                  -DBUILD_SHARED_LIBS=ON"

DISABLE_STATIC:class-nativesdk = ""
DISABLE_STATIC:class-native = ""

CVE_STATUS[CVE-2024-35325] = "upstream-wontfix: Upstream thinks this is a misuse (or wrong use) of the libyaml API - https://github.com/yaml/libyaml/issues/303"
CVE_STATUS[CVE-2024-35326] = "upstream-wontfix: Upstream thinks there is no working code that is exploitable - https://github.com/yaml/libyaml/issues/302"
CVE_STATUS[CVE-2024-35328] = "upstream-wontfix: Upstream thinks there is no working code that is exploitable - https://github.com/yaml/libyaml/issues/302"

BBCLASSEXTEND = "native nativesdk"
