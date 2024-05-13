SUMMARY = "Cross Origin Resource Sharing ( CORS ) support for Flask"
HOMEPAGE = "https://github.com/corydolphin/flask-cors"
DESCRIPTION = "Cross Origin Resource Sharing ( CORS ) support for Flask"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=118fecaa576ab51c1520f95e98db61ce"

SRC_URI[sha256sum] = "f268522fcb2f73e2ecdde1ef45e2fd5c71cc48fe03cffb4b441c6d1b40684eb0"

PYPI_PACKAGE = "Flask-Cors"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/Flask-Cors-${PV}"

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
