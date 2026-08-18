SUMMARY = "Command-line tool for generating documentation for ROS 2 packages."
DESCRIPTION = "\
    This tool can be viewed from two perspectives: \
    first from the perspective of a user wanting to building documentation for any given ROS 2 package in order to view it, \
    and second from the perspective of package maintainers who need to write their documentation \
    and configure how this tool works on their package. \
"
HOMEPAGE = "https://github.com/ros-infrastructure/rosdoc2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=10;endline=10;md5=d36ab912b8b544b7412f2d84c52072f1"

DEPENDS = "python3-wheel-native"

SRC_URI = "\
    git://github.com/ros-infrastructure/rosdoc2.git;branch=main;protocol=https \
    file://0001-ptest-fix-the-path-to-the-installed-package.patch \
"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
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

BBCLASSEXTEND = "native nativesdk"
