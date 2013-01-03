DESCRIPTION = "The installer for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=7184a9afd29fc7d6490a284f23c5365e"
SRCNAME = "rosinstall"

SRC_URI = "http://pr.willowgarage.com/downloads/rosinstall/rosinstall-0.6.21.tar.gz"
SRC_URI[md5sum] = "079784ac80779f17dab699087103a2c3"
SRC_URI[sha256sum] = "7163106c93460c8d092c5e74749cefd3fc17295f3a06c4f041fe83a772a86d14"

S = "${WORKDIR}/${SRCNAME}-${PV}"

# install_requires=['vcstools', 'pyyaml'],
DEPENDS += "python-vcstools python-pyyaml"

inherit setuptools

