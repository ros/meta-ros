
SUMMARY = "Extension for colcon to provide Bash scripts."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=21;endline=21;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "29a223a66828e18aad9b8db5087f7114e388601830091830ca17b095ada2cbac"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
