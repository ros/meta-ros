SUMMARY = "The parser for the manifest files in the ament buildsystem."
HOMEPAGE = "https://github.com/ament/ament_package"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "2cc251b627607e2d8ada6fa75add45cbe86cb9d8"
SRC_URI = "git://github.com/ament/ament_package.git;protocol=git;"

S = "${WORKDIR}/git"

inherit setuptools3

BBCLASSEXTEND += "native"
