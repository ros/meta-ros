
SUMMARY = "Extension for colcon to support CMake packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "5e910890148d9d3c7f82f5c0e97904478e0e0bf156b786729099ead73d6ec4f0"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-colcon-library-path \
    python3-colcon-test-result \
"

BBCLASSEXTEND += "nativesdk"
