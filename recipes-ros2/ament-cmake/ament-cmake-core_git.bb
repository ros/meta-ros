SUMMARY = "The core of the ament buildsystem in CMake."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = "ament-package-native ${PYTHON_PN}-pyparsing-native"

include ament-cmake.inc

RDEPENDS_${PN} += "ament-package cmake"
