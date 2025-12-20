
SUMMARY = "Extension for colcon to provide information about all extension points and extensions"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "34ae3877f60ce04f50acbf11ceadb660e6eaebde837e6d8b035ab9fb8ca36e05"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
