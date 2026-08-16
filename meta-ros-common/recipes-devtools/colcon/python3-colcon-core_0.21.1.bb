SUMMARY = "Command line tool to build sets of software packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-core;branch=master;protocol=https \
    file://0002-Force-shebang-to-usr-bin-env-python3.patch \
    file://0001-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0002-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "6428dca140c5b060c5fc5ef134c1338be78b129d"

inherit setuptools3 ptest-python-pytest

# See: https://github.com/colcon/colcon-core/blob/master/setup.cfg
RDEPENDS:${PN} += "\
    python3-coloredlogs \
    python3-core \
    python3-distlib \
    python3-empy \
    python3-packaging \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND = "native nativesdk"

INSANE_SKIP:${PN}-ptest += "file-rdeps"
