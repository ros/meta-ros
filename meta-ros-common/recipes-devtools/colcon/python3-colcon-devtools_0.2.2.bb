
SUMMARY = "Extension for colcon to provide information about all extension points and extensions"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "6ed3f29052c44e021b64106d5ae338e2b8936ba58c9f1c0496478327973d3f7b"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
