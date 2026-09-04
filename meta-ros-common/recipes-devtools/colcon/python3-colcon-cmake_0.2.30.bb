SUMMARY = "Extension for colcon to support CMake packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-cmake;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-increase-cmake_minimum_required.patch \
    file://0003-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "5d6bc11dae5d6f682b0e5e80e7c01204eb190833"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-colcon-library-path \
    python3-colcon-test-result \
"

RDEPENDS:${PN}-ptest += "\
    cmake \
    make \
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
