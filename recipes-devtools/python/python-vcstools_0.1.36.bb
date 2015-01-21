DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "vcstools"

SRC_URI = "https://pypi.python.org/packages/source/v/vcstools/vcstools-${PV}.tar.gz"
SRC_URI[md5sum] = "e3ef997da464cf284ca36fd60e993ed6"
SRC_URI[sha256sum] = "83b38c3f055454590333debdb6db23b3f5ed694e6a27fb506e8639bf87a4d61e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-pyyaml python-dateutil"

inherit setuptools
