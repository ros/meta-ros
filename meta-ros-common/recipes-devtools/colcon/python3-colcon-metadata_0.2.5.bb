
SUMMARY = "Extension for colcon to read package metadata from files."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "137c740ce10e29219c4d89c4f0dac8549e46bfb6e3bc2296fe2d051bdb971ec8"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-pyyaml \
"

BBCLASSEXTEND += "nativesdk"
