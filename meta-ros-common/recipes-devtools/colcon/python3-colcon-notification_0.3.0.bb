
SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "c45b898073a8e98c4518333b7587f9ea49ac1bc129a7bc4e1390059057031fb8"

inherit pypi setuptools3

# TODO: we might require some notification library.
RDEPENDS:${PN} += "\
    python3-colcon-core \
"

BBCLASSEXTEND += "nativesdk"

FILES:${PN} += "${datadir}/colcon_notification"
