DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=988919d688133096537549f9afebf425"

inherit setuptools3 ptest-python-pytest

ROS_BRANCH ?= "branch=master"
SRC_URI = "\
    git://github.com/ros-infrastructure/rosdistro;${ROS_BRANCH};tag=${PV};protocol=https \
"

SRCREV = "960790d1e03c172a68f639190e71ba1fd04e81b9"

RDEPENDS:${PN} += "\
    python3-packaging \
    python3-pyyaml \
"

RDEPENDS:${PN}-ptest += "\
    git \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND = "native nativesdk"
