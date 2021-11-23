
SUMMARY = "Extension for colcon to customize the output in various ways."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "6aae1ffe73ae956bcb36e330822cd230a2a88c9181b3170aafd1a446638e69b3"

inherit pypi setuptools3

# TODO: we might require some notification library.
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-core \
"

BBCLASSEXTEND += "nativesdk"

FILES:${PN} += "${datadir}/colcon_notification"
