
SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "a211e9f1f70edb1567c0747532ad222e47799cef25cb863e4a43af4660798b30"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
