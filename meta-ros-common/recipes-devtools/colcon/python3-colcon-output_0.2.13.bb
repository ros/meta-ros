
SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "44d2d349ebdb61688b41e00d565ea1a199e8fc5c2c77af279cfaac74dc01c04d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
