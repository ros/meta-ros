DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a8aaf0595c2efc1a9c2e0913e9c1a2c"

PR = "r0"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/jbeder/${BPN}.git;branch=master;protocol=https"
SRCREV = "562aefc114938e388457e6a531ed7b54d9dc1b62"


EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON -DYAML_CPP_BUILD_TESTS=OFF -DYAML_CPP_BUILD_TOOLS=OFF -DYAML_CPP_BUILD_CONTRIB=OFF"

inherit cmake

PACKAGES =+ "${PN}-gtest"
FILES:${PN}-gtest += " \
    ${libdir}/libgmock_main.so \
    ${libdir}/libgtest_main.so \
    ${libdir}/libgtest.so \
    ${libdir}/libgmock.so \
"

BBCLASSEXTEND = "native nativesdk"
