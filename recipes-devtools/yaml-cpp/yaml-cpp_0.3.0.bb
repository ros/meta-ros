DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=7c6a629da965ebdfba9f6fdb76ab8ab4"

PR = "r0"

S = "${WORKDIR}/yaml-cpp-release-${PV}"

SRC_URI = "https://github.com/jbeder/yaml-cpp/archive/release-${PV}.tar.gz"
SRC_URI[md5sum] = "0c0496b195299e956056430444e237b9"
SRC_URI[sha256sum] = "ab8d0e07aa14f10224ed6682065569761f363ec44bc36fcdb2946f6d38fe5a89"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

inherit cmake
