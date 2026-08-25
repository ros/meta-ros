SUMMARY = "Extension for colcon to support Python packages with the metadata in the setup.py file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-python-setup-py;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
    file://0003-ptest-mark-flake8-tests-as-expected-to-fail.patch \
"

SRCREV = "c0725a01c9c03849130c1f377336097ffa179042"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-setuptools \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
