SUMMARY = "Flake8 extension to check if a new line is present after a class definition."
HOMEPAGE = "https://github.com/AlexanderVanEck/flake8-class-newline"
DESCRIPTION = "Flake8 extension to check if a new line is present after a class definition."
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5debb370f50e1dfd24ff5144233a2ef6"

PYPI_PACKAGE = "flake8-class-newline"

SRC_URI[sha256sum] = "514c4923c88eb8b3dd52db4b55b8d3483520db89db80af6ba812a4af15421ff1"

inherit pypi

S = "${UNPACKDIR}/flake8-class-newline-1.6.0"

BBCLASSEXTEND = "native nativesdk"
