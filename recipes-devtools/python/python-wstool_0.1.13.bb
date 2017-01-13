DESCRIPTION = "workspace multi-SCM commands"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "wstool"

SRC_URI = "http://download.ros.org/downloads/wstool/wstool-${PV}.tar.gz"
SRC_URI[md5sum] = "7e41a0e4f92389a6b4e115c80dd5cf10"
SRC_URI[sha256sum] = "4eaed3f94bf7842a2076de6dbef9396a8dbf055a13eee313366818465a270244"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-vcstools python-pyyaml python-rosinstall"

inherit setuptools
