DESCRIPTION = "PyGraphviz is a Python interface to the Graphviz graph layout and visualization package"
HOMEPAGE = "https://pygraphviz.github.io"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09d1f41013f91e294baad78b57be0746"

SRC_URI[sha256sum] = "c10df02377f4e39b00ae17c862f4ee7e5767317f1c6b2dfd04cea6acc7fc2bea"

DEPENDS = "graphviz"

PYPI_PACKAGE_EXT = "tar.gz"
inherit pypi pkgconfig python_setuptools_build_meta

BBCLASSEXTEND = "native"
