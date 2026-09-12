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

SRCREV = "f3c11b2d810159e7063daddeaa0764f4006e5a73"

inherit cmake

EXTRA_OECMAKE = "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"

FILES:${PN} += "\
    ${prefix}/etc/xeus-cpp/tags.d/xtensor.json \
    ${datadir}/xeus-cpp/tagfiles/xtensor.tag \
"
