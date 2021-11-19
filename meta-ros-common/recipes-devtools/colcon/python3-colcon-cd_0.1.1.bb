
SUMMARY = "A shell function for colcon to change the current working directory."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=21;endline=21;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "379ef4d9f4bb3557d48ea25230ec5d749e83bb2814319e5a1d5ba5810df7b584"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-colcon-package-information \
"

FILES:${PN} += "\
    ${datadir}/colcon_cd \
"

BBCLASSEXTEND += "nativesdk"
