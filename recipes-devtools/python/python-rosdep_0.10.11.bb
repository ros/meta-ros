DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=5173cedd7e973a185ca40c868297bf34"
SRCNAME = "rosdep"

SRC_URI = "http://pypi.python.org/packages/source/r/rosdep/rosdep-0.10.11.tar.gz"
SRC_URI[md5sum] = "7429037eacb614a753112a10ea86698c"
SRC_URI[sha256sum] = "c3e741db57b7230c8ac2cceca837b98181b4fa6d1488819e615366a858d8c413"

S = "${WORKDIR}/${SRCNAME}-${PV}"

# install_requires=['catkin_pkg', 'rospkg', 'PyYAML >= 3.1'],
# setup_requires=['nose >= 1.0'],

RDEPENDS_${PN} += "python-catkin-pkg python-rospkg python-pyyaml"

inherit setuptools
