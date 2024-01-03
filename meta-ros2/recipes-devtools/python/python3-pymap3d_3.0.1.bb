SUMMARY = "pure-Python (Numpy optional) 3D coordinate conversions for geospace ecef enu eci"
HOMEPAGE = "https://github.com/geospace-code/pymap3d"
DESCRIPTION = "pure Python (no prereqs) coordinate conversions, following convention of several popular Matlab routines."
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=913e2367dfc80a3cb9b041d9fe8e26e5"

SRC_URI[sha256sum] = "09a80a8ca7abd3f089c4d5a7d7a5827bec023160efd4356d809b02550508b4c5"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/pymap3d-3.0.1"

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
