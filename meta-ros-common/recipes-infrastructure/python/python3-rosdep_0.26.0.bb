DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86a73ab7b555900fd6b51429658aca4c"

ROS_BRANCH ?= "branch=master"

SRC_URI = "\
    git://github.com/ros-infrastructure/rosdep;${ROS_BRANCH};protocol=https \
    file://0001-ptest-skip-tests-for-OE-Yocto.patch \
    file://0002-ptest-bin-bash-is-not-installed.patch \
"

SRCREV = "ad3a6103b485030c12275703a086878acf33922a"

inherit setuptools3 ptest-python-pytest

FILES:${PN}-ptest += "${PTEST_PATH}/setup.cfg"

RDEPENDS:${PN} += "\
    ca-certificates \
    python3-catkin-pkg \
    python3-netclient \
    python3-pyyaml \
    python3-rosdistro \
"

RDEPENDS:${PN}-ptest += "\
    python3-flake8 \
    python3-pip \
    python3-pycodestyle \
    python3-rospkg \
"

PTEST_PYTEST_DIR = "test"

do_install_ptest:append() {
    install -d ${D}${PTEST_PATH}
    install -m 0644 ${S}/setup.cfg ${D}${PTEST_PATH}/
    install -m 0644 ${S}/test/source/noop-not-installed.rdmanifest ${D}${PTEST_PATH}/
}

BBCLASSEXTEND += "native"
