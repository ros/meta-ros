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

SRCREV = "f115228a7fc277b9be1bef34572831f8fd53ac73"

inherit cmake

