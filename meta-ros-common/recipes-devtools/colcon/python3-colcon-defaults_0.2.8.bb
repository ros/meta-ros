
SUMMARY = "Extension for colcon to read defaults from a config file."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "053e8a18fbae04cf182a2968d7f7ed474c5125bf3b306b8049250574f4096fa1"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
    python3-pyyaml \
"

BBCLASSEXTEND += "nativesdk"
