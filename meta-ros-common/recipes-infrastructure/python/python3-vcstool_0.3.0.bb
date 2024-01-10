DESCRIPTION = "Command line tool to make working with multiple repositories easier"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ac031eef55bb823c0c5d412881bef4b"
SRCNAME = "vcstool"

SRC_URI = "http://deb.debian.org/debian/pool/main/r/ros-vcstool/ros-vcstool_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "d96b39878a3da1935db8c0bf5f157e25"
SRC_URI[sha256sum] = "2b6e4a97454983166e9a5fe08aca41cd8b28288ef693b954bc0e8b8518eafd3b"

S = "${WORKDIR}/${SRCNAME}-${PV}"

FILES:${PN} += "${datadir}/vcstool-completion"

RDEPENDS:${PN} += "python3-pyyaml"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
