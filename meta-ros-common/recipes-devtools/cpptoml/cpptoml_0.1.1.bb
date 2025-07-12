SUMMARY = "cpptoml is a header-only library for parsing TOML"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8739ce451f437fa9493b37a405fb16f1"

SRC_URI = "gitsm://github.com/skystrife/cpptoml.git;protocol=https;branch=master \
           file://0001-Fix-build-with-gcc-11.patch \
           file://0002-Fix-build-with-clang.patch \
	   file://0003-Fix-build-with-CMake-4.0.patch"

PV = "0.1.1+git"
SRCREV = "fededad7169e538ca47e11a9ee9251bc361a9a65"

S = "${UNPACKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native"
