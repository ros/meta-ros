
SUMMARY = "Extension for colcon to read defaults from a config file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "ac40fc4ec85cc0633d6c56aa6ebb43203c373cd919d554b1f07fb8f27fdaa2d2"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-pyyaml \
"

BBCLASSEXTEND += "nativesdk"
