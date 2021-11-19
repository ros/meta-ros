
SUMMARY = "Extension for colcon to provide information about the test results."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "aa5225716a5bdd9f1df721e7a04f1e02150def8c86dd070793cb62e747c36ed3"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
