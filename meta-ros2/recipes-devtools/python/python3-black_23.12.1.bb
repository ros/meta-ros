SUMMARY = "The uncompromising code formatter."
HOMEPAGE = "https://github.com/psf/black"
DESCRIPTION = "The uncompromising code formatter."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d3465a2a183908c9cb95bf490bd1e7ab"

SRC_URI += "file://downgrade-hatchling-requirement.patch"

SRC_URI[sha256sum] = "4ce3ef14ebe8d9509188014d96af1c456a910d5b5cbf434a09fef7e024b3d0d5"

inherit pypi python_hatchling

S = "${WORKDIR}/black-${PV}"

DEPENDS += " \
    python3-hatch-fancy-pypi-readme-native \
    python3-hatch-vcs-native \
"

BBCLASSEXTEND = "native nativesdk"
