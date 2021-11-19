
SUMMARY = "Extension for colcon to provide Bash scripts."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=21;endline=21;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "86950ca62293b655ef8d655d2994d110321fff2fc6739c46a64f005a0cee1bdd"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
