

SUMMARY = "Functions for 3D coordinate transformations"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://setup.py;beginline=36;endline=36;md5=6dd3a8a8bcf9d24e830b974bf9345e72"

SRC_URI[sha256sum] = "404c7797c78aa461cb8043081901fc5517cef342d5ff56becd74a7967ba88d78"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-numpy \
"

