SUMMARY = "Command-line tool for generating documentation for ROS 2 packages."
DESCRIPTION = "\
    This tool can be viewed from two perspectives: \
    first from the perspective of a user wanting to building documentation for any given ROS 2 package in order to view it, \
    and second from the perspective of package maintainers who need to write their documentation \
    and configure how this tool works on their package. \
"
HOMEPAGE = "https://github.com/ros-infrastructure/rosdoc2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "\
    git://github.com/ros-infrastructure/rosdoc2.git;branch=main;protocol=https \
    file://0001-ptest-fix-the-path-to-the-installed-package.patch \
"

SRCREV = "978d4a81812504bf93964ecc41ea3022cfa49387"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    doxygen \
    osrf-pycommon \
    python3-breathe \
    python3-catkin-pkg \
    python3-exhale \
    python3-jinja2 \
    python3-myst-parser \
    python3-pyyaml \
    python3-rosdistro \
    python3-setuptools \
    python3-sphinx \
    python3-sphinx-rtd-theme \
    "

PYPI_PACKAGE = "rosdoc2"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pycodestyle \
"

PTEST_PYTEST_DIR = "test"

do_install_ptest:append() {
    install -d ${D}${PTEST_PATH}
    install -m 0644 ${S}/setup.cfg ${D}${PTEST_PATH}/
    cp -r ${S}/test/packages ${D}${PTEST_PATH}/
}

BBCLASSEXTEND = "native nativesdk"
