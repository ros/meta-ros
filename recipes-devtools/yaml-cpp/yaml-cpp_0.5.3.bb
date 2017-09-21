DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a8aaf0595c2efc1a9c2e0913e9c1a2c"

DEPENDS = "boost"

PR = "r0"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/jbeder/${PN}.git;branch=master;protocol=git"
SRCREV = "b57efe94e7d445713c29f863adb8c23438eaa217"


EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

inherit cmake
