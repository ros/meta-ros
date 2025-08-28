SUMMARY = "A Python module to customize the process title"
HOMEPAGE = "https://github.com/dvarrazzo/py-setproctitle"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=86d2d41b5f4f023f43466f8cb7adebaa"

SRC_URI[sha256sum] = "c9f32b96c700bb384f33f7cf07954bb609d35dd82752cef57fb2ee0968409169"

inherit pypi setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "test"
PACKAGECONFIG[test] = ",,,python3-pytest"


# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "setproctitle"

# From d2e82fc12509950ea30fa20fcbe9fc148b6cff1c
FILES:${PN}-tkinter += "${libdir}/python${PYTHON_MAJMIN}/lib-dynload/_tkinter.*.so"
