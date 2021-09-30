DESCRIPTION = "PyGraphviz is a Python interface to the Graphviz graph layout and visualization package"
HOMEPAGE = "https://pygraphviz.github.io"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aea17a9f438962a6de1b682d4641731"

SRC_URI[md5sum] = "c186f5f6567e523a862063fc62ddcd2f"
SRC_URI[sha256sum] = "50a829a305dc5a0fd1f9590748b19fece756093b581ac91e00c2c27c651d319d"

DEPENDS = "${PYTHON_PN} graphviz"

PYPI_PACKAGE_EXT = "zip"
inherit pypi pkgconfig

BBCLASSEXTEND = "native"
