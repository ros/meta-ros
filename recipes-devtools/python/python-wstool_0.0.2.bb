DESCRIPTION = "workspace multi-SCM commands"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=895a8f494dfd956e0ef03c9a5e3f109e"
SRCNAME = "wstool"

SRC_URI = "http://pypi.python.org/packages/source/w/wstool/wstool-0.0.2.tar.gz"
SRC_URI[md5sum] = "58180962de7c2f426fe9e0525f878c48"
SRC_URI[sha256sum] = "487602f7d5bef1e0b759c60ab4b86db884dd2abfb756e1743ad4ae3754a22d82"

S = "${WORKDIR}/${SRCNAME}-${PV}"

# install_requires=['vcstools', 'pyyaml', 'rosinstall'],
RDEPENDS_${PN} += "python-vcstools python-pyyaml python-rosinstall"

inherit setuptools
