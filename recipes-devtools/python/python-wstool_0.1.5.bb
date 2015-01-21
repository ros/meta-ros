DESCRIPTION = "workspace multi-SCM commands"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "wstool"

SRC_URI = "http://pypi.python.org/packages/source/w/wstool/wstool-${PV}.tar.gz"
SRC_URI[md5sum] = "2b5d10fac0bb644146a8c3009e5aa14b"
SRC_URI[sha256sum] = "0c65719af85247e5fcdf07ad2ad50eac3268cf1ca7ba9c9c43037d345de88de8"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-vcstools python-pyyaml python-rosinstall"

inherit setuptools
