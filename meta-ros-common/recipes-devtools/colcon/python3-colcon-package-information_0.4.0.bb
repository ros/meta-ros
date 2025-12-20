
SUMMARY = "Extension for colcon to output package information."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "20f5184ae1b05db0a76f244bc85622f6b25e48ef7398f55784ccfe455d40bcfb"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
