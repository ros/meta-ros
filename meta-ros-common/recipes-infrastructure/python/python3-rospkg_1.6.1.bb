DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/rospkg/__init__.py;beginline=1;endline=31;md5=9cea8ac73441707f7779ae66adf75f62"
SRCNAME = "rospkg"

SRCREV = "3c1f9c6d5d884dd42ee7388b9dc97d082794d207"
ROS_BRANCH ?= "branch=master"
SRC_URI = " \
    git://github.com/ros-infrastructure/rospkg;${ROS_BRANCH};protocol=https \
    file://0001-Detect-the-OpenEmbedded-OS-with-lsb.patch \
"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-distro \
    python3-rosdep \
    python3-xml \
"

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND = "native"

