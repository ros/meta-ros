SUMMARY = "The entry point package for the ament buildsystem in CMake."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = "ament-cmake-export-dependencies-native"

include ament-cmake.inc

RDEPENDS_${PN} += " \
    ament-cmake-core \
    ament-cmake-export-definitions \
    ament-cmake-export-dependencies \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-libraries \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-test \
"
