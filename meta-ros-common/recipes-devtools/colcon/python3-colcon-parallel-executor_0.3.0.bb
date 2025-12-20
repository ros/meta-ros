
SUMMARY = "Extension for colcon to process packages in parallel."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "e7137fcaf4c61db792955fd641bfad7dbad4b41928c6b81ff87a78339e116644"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
