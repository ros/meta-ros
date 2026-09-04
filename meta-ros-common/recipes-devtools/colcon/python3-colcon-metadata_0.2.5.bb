SUMMARY = "Extension for colcon to read package metadata from files."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-metadata;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
    file://0100-Address-flake8-E721-violations-32.patch \
    file://0101-flake8-no-global-variable-needed-in-function.patch \
"

SRCREV = "efff0809b7615c3efc1b84edb5c444b528b274c1"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-pyyaml \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
