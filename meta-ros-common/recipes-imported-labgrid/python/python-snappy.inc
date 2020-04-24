# Imported as-is from
# https://github.com/labgrid-project/meta-labgrid/commit/0bdddba7449375b809b9f470318f4538dda27283

DESCRIPTION = "Python library for the snappy compression library from Google"
HOMEPAGE = "http://github.com/andrix/python-snappy"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b3090152f53ee19f6a7b64b1a36384fb"

inherit pypi

PYPI_PACKAGE = "python-snappy"

DEPENDS += "snappy"
RDEPENDS_${PN} += "snappy"
