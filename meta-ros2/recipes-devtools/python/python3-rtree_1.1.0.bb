SUMMARY = "R-Tree spatial index for Python GIS"
HOMEPAGE = "https://github.com/Toblerity/rtree"
DESCRIPTION = "R-Tree spatial index for Python GIS"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=871f352e16f6f2e241007b3bc494418a"

SRC_URI[sha256sum] = "6f8ee504dde5d005b25b08aaf5be0b3404af3ad5fece6e1ddcde35908a798a95"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/Rtree-${PV}"

PYPI_PACKAGE = "Rtree"

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
