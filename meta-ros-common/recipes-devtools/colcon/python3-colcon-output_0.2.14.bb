SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-output;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "afc8301923a4c88dd2c7d2cb00eb4747d8c2ddc0"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
