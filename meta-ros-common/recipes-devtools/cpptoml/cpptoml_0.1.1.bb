LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8739ce451f437fa9493b37a405fb16f1"

SRC_URI = "gitsm://github.com/skystrife/cpptoml.git;protocol=https;branch=master \
           file://0001-Fix-build-with-gcc-11.patch"

PV = "0.1.1+git"
SRCREV = "fededad7169e538ca47e11a9ee9251bc361a9a65"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native"
