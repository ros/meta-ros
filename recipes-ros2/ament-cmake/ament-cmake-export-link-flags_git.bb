SUMMARY = "The ability to export link flags to downstream packages in the ament buildsystem."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = "ament-cmake-core-native"

include ament-cmake.inc

RDEPENDS_${PN} += "ament-cmake-core"
