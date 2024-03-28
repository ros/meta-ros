SUMMARY = "Manipulation and analysis of geometric objects"
HOMEPAGE = "https://github.com/shapely/shapely"
DESCRIPTION = "Manipulation and analysis of geometric objects"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=771eb47113291428a083f6bf398fa3cb"

SRC_URI[sha256sum] = "1713cc04c171baffc5b259ba8531c58acc2a301707b7f021d88a15ed090649e7"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/shapely-${PV}"

do_configure:prepend() {
cat > ${S}/setup.py <<-EOF
from setuptools import setup

setup(
       name="${PYPI_PACKAGE}",
       version="${PV}",
       license="${LICENSE}",
)
EOF
}

BBCLASSEXTEND = "native nativesdk"
