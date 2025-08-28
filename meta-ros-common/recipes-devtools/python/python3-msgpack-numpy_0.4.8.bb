SUMMARY = "Numpy data serialization using msgpack"
HOMEPAGE = "https://github.com/lebedov/msgpack-numpy"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=5aeddef37208d742de52b72b2af83ded"

SRC_URI[sha256sum] = "c667d3180513422f9c7545be5eec5d296dcbb357e06f72ed39cc683797556e69"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-msgpack python3-numpy"

RDEPENDS:${PN} += "python3-core python3-numpy python3-pickle"

PYPI_PACKAGE = "msgpack-numpy"
