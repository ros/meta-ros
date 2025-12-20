
SUMMARY = "Extension for colcon to support Python packages with the metadata in the setup.py file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "4d8bab2e05ba334e29eee3715fbde490281342ed8e000e252130e5c51915383a"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-setuptools \
"

BBCLASSEXTEND += "nativesdk"
