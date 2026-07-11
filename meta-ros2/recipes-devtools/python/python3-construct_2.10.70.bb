SUMMARY = "Declarative data structures for python"
DESCRIPTION = "Declarative data structures for python that allow symmetric parsing and building"
HOMEPAGE = "https://construct.readthedocs.io/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=202b39559c1c79fe4715ce81e9e0ac02"

SRC_URI = "git://github.com/construct/construct.git;protocol=https;branch=master"

SRCREV = "c25a47172d4bde392b7ad188175b07b319d3dea4"

inherit setuptools3

#RDEPENDS:${PN} = "\
#  ${PYTHON_PN}-unittest \
#  "

BBCLASSEXTEND = "native nativesdk"
