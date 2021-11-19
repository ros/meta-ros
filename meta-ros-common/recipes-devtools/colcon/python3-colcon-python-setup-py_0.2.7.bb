
SUMMARY = "Extension for colcon to support Python packages with the metadata in the setup.py file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "eec293085c4301797706d9e61634fa0cb2136be9b820aa556b2b8baa0bde412d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-setuptools \
"

BBCLASSEXTEND += "nativesdk"
