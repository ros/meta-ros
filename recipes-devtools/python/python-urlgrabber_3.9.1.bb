DESCRIPTION = "A high-level cross-protocol url-grabber"
SECTION = "devel/python"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=68ad62c64cc6c620126241fd429e68fe"
SRCNAME = "urlgrabber"

DEPENDS = "python-pycurl-native python-pycurl"

SRC_URI = "https://pypi.python.org/packages/source/u/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "00c8359bf71062d0946bacea521f80b4"
SRC_URI[sha256sum] = "4437076c8708e5754ea04540e46c7f4f233734ee3590bb8a96389264fb0650d0"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
