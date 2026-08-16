SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-notification;branch=master;protocol=https \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "728784f041fd23fc2060b57c5137320cde444af9"

inherit setuptools3 ptest-python-pytest

FILES:${PN} += "${datadir}/colcon_notification"

# TODO: we might require some notification library.
RDEPENDS:${PN} += "\
    python3-colcon-core \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
