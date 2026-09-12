SUMMARY = "C++ tensors with broadcasting and lazy computing"
HOMEPAGE = "https://xtensor.readthedocs.io"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c67ec4d3eb9c5b7eed4c37e69571b93"

DEPENDS = "\
    nlohmann-json \
    tbb \
    xsimd \
    xtl \
"

SRC_URI = "git://github.com/xtensor-stack/xtensor.git;protocol=https;branch=master"

SRCREV = "3634f2ded19e0cf38208c8b86cea9e1d7c8e397d"

inherit cmake

FILES:${PN} += "\
    ${prefix}/etc/xeus-cpp/tags.d/xtensor.json \
    ${datadir}/xeus-cpp/tagfiles/xtensor.tag \
"
