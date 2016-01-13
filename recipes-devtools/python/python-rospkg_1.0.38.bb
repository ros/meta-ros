DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rospkg"

SRC_URI = "http://pypi.python.org/packages/source/r/rospkg/rospkg-${PV}.tar.gz"
SRC_URI[md5sum] = "9953ac8a1e6c393ff27dcec8cb88feb5"
SRC_URI[sha256sum] = "774b478fb7b2fe49733d40c120af785af898b838ef1a0082951351e0113b8c32"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-xml"

inherit setuptools

BBCLASSEXTEND = "native"
