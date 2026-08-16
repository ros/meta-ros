SUMMARY = "Extension for colcon to support ROS packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "\
    git://github.com/colcon/colcon-ros;branch=master;protocol=https \
    file://0001-Drop-unnecessary-scope-qualifiers-to-please-flake8.patch \
    file://0101-ptest-no-python3-scspell-in-OpenEmbedded-Yocto.patch \
    file://0102-ptest-correct-path-of-the-to-be-checked-python-files.patch \
"

SRCREV = "7c72610ded646405d3c61318680e7d93bcbf1409"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-catkin-pkg \
    python3-colcon-cmake \
    python3-colcon-core \
    python3-colcon-pkg-config \
    python3-colcon-python-setup-py \
    python3-colcon-recursive-crawl \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND += "nativesdk"
