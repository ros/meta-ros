SUMMARY = "This plugin produces coverage reports."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbc4e25353c748c817db2daffe605e43"

inherit setuptools3 pypi
PYPI_PACKAGE = "pytest-cov"

SRC_URI[sha256sum] = "8535764137fecce504a49c2b742288e3d34bc09eed298ad65963616cc98fd45e"
