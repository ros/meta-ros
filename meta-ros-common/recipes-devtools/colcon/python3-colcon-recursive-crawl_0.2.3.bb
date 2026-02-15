
SUMMARY = "Extension for colcon to recursively crawl for packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "fca5f619214d20306daaf012f91399d4d3b605364b121e5df80399432c55c603"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"
