SUMMARY = "Declarative data structures for python"
HOMEPAGE = "https://construct.readthedocs.io/"
DESCRIPTION = "Declarative data structures for python that allow symmetric parsing and building"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=202b39559c1c79fe4715ce81e9e0ac02"

SRC_URI = "git://github.com/construct/construct.git;protocol=https;branch=master"

SRCREV = "a6603d7821480fb5a4e6665c6fd8028ce574c4bd"

# inherit pypi
inherit setuptools3

#RDEPENDS:${PN} = "\
#  ${PYTHON_PN}-unittest \
#  "

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
