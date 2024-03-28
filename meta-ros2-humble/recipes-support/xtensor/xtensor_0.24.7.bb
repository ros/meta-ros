LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c67ec4d3eb9c5b7eed4c37e69571b93"

SRC_URI = "git://github.com/xtensor-stack/xtensor.git;protocol=https;branch=master"

PV = "0.24.7+git${SRCPV}"
SRCREV = "44b56bbae2185ebf19e6f617ac5690344b9e35a4"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "xtl nlohmann-json tbb xsimd"
