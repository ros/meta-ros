DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "vcstools"

SRC_URI = "http://download.ros.org/downloads/vcstools/vcstools-${PV}.tar.gz"
SRC_URI[md5sum] = "ae2f802460458142727d69c46315ae54"
SRC_URI[sha256sum] = "80c5bef67d9b4933b962565bd9b012d001a44b72b9157da3623ace980213427e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-pyyaml python-dateutil"

inherit setuptools
