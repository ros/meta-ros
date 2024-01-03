SUMMARY = "Fiona reads and writes spatial data files"
HOMEPAGE = "https://github.com/Toblerity/Fiona"
DESCRIPTION = "Fiona reads and writes spatial data files"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=17e3ee10f678b8903ff95af5cda9023a"

SRC_URI[sha256sum] = "99e2604332caa7692855c2ae6ed91e1fffdf9b59449aa8032dd18e070e59a2f7"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/fiona-${PV}"

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
