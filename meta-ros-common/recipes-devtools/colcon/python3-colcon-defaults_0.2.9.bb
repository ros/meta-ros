SUMMARY = "Extension for colcon to read defaults from a config file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-defaults;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "c76ba3c8240a44046c138b8e7d3b597e81415bcf"

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
