
SUMMARY = "Extension for colcon to support CMake packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "5a227fe812766be5fc3895c821bf9190f571e8c25eb73962967310d6b524349f"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-colcon-library-path \
    ${PYTHON_PN}-colcon-test-result \
"

BBCLASSEXTEND += "nativesdk"
